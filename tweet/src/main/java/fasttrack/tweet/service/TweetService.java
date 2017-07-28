package fasttrack.tweet.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import fasttrack.tweet.dto.ContentCredentialsDto;
import fasttrack.tweet.dto.CredentialsDto;
import fasttrack.tweet.dto.TweetDto;
import fasttrack.tweet.entity.HashTag;
import fasttrack.tweet.entity.Tweet;
import fasttrack.tweet.entity.User;
import fasttrack.tweet.mapstruct.TagMapper;
import fasttrack.tweet.mapstruct.TweetMapper;
import fasttrack.tweet.mapstruct.UserMapper;
import fasttrack.tweet.repository.TagRepository;
import fasttrack.tweet.repository.TweetRepository;
import fasttrack.tweet.repository.UserRepository;

@Service
public class TweetService {

	private UserMapper usermapper;
	private UserRepository userrepo;
	private TagMapper tagmapper;
	private TagRepository tagrepo;
	private TweetMapper tweetmapper;
	private TweetRepository tweetrepo;

	public TweetService(UserMapper usermapper, UserRepository userrepo, TagMapper tagmapper, TagRepository tagrepo,
			TweetMapper tweetmapper, TweetRepository tweetrepo) {
		super();
		this.usermapper = usermapper;
		this.userrepo = userrepo;
		this.tagmapper = tagmapper;
		this.tagrepo = tagrepo;
		this.tweetmapper = tweetmapper;
		this.tweetrepo = tweetrepo;
	}

	public List<Tweet> getAllTweets() {
		return tweetrepo.findByActiveEqualsOrderByPostedDesc(true);
	}

	public List<Tweet> getRepostById(String id) {
		List<Tweet> tweets= tweetrepo.findRepostsByActiveAndIdEqualsOrderByPostedDesc(true, id);
		for(Tweet tweet : tweets){
			if(tweet.isActive()==false) tweets.remove(tweet);
		}
		return tweets;
	}

	public List<Tweet> getRepliesById(String id) {
		List<Tweet> tweets= tweetrepo.findRepliesByActiveAndIdEqualsOrderByPostedDesc(true, id);
		for(Tweet tweet : tweets){
			if(tweet.isActive()==false) tweets.remove(tweet);
		}
		return tweets;
	}

	public List<User> getMentionsById(String id) {
		List<User> users= tweetrepo.findMentionsByActiveAndIdEquals(true, id);
		for(User user : users){
			if(user.isActive()==false) users.remove(user);
		}
		return users;
	}

	public List<User> getLikesById(String id) {
		List<User> users= tweetrepo.findLikesByActiveAndIdEquals(true, id);
		for(User user : users){
			if(user.isActive()==false) users.remove(user);
		}
		return users;
	}

	public List<HashTag> getTagsById(String id) {
		return tweetrepo.findTagsByActiveAndIdEquals(true,id);
	}

	public TweetDto getTweetById(String id) {
		return tweetmapper.toDto(tweetrepo.findByActiveAndIdEquals(true,id));
	}

	public TweetDto post(ContentCredentialsDto inputDto) {
		Tweet tweet = new Tweet();
		tweet.setAuthor(userrepo.findByActiveAndCredentials_UsernameEquals(true, inputDto.getCredentials().getUsername()));
		tweet.setContent(inputDto.getContent());
		parseContent(tweet);
		tweetrepo.save(tweet);
		return tweetmapper.toDto(tweet);
	}

	private void parseContent(Tweet tweet) {
		String[] content = tweet.getContent().split("\\s+");
		for(String s : content){
			if(s.matches("@\\S+")) tweet.getMentions().add(userrepo.findByActiveAndCredentials_UsernameEquals(true, s.replaceFirst("@", "")));
			if(s.matches("#\\S+")) {
				HashTag tag = tagrepo.findByLabelEquals(s.replaceFirst("#", ""));
				tag.setLastUsed(new Timestamp(System.currentTimeMillis()));
				tweet.getTags().add(tag);
			}
		}
		
	}

	public void likeTweetById(CredentialsDto inputDto, String id) {
		Tweet tweet = tweetmapper.toTweet(getTweetById(id));
		User user = userrepo.findByActiveAndCredentials_UsernameEquals(true, inputDto.getUsername());
		user.getLikes().add(tweet);
		userrepo.save(user);
	}

	public TweetDto repostTweetById(CredentialsDto inputDto, String id) {
		Tweet tweet = tweetmapper.toTweet(getTweetById(id));
		Tweet repost = new Tweet();
		repost.setAuthor(userrepo.findByActiveAndCredentials_UsernameEquals(true, inputDto.getUsername()));
		repost.setContent(tweet.getContent());
		repost.setRepostof(tweet);
		tweetrepo.save(repost);
		return tweetmapper.toDto(repost);

	}

	public TweetDto replyTweetById(ContentCredentialsDto inputDto, String id) {
		Tweet tweet = tweetmapper.toTweet(getTweetById(id));
		Tweet reply = new Tweet();
		reply.setAuthor(userrepo.findByActiveAndCredentials_UsernameEquals(true, inputDto.getCredentials().getUsername()));
		reply.setContent(inputDto.getContent());
		reply.setInReplyTo(tweet);
		tweetrepo.save(reply);
		return tweetmapper.toDto(reply);
	}

	public Tweet deleteTweet(CredentialsDto inputDto, String id) {
		Tweet tweet = tweetmapper.toTweet(getTweetById(id));
		tweet.setActive(false);
		tweetrepo.save(tweet);
		return tweet;
	}

}
