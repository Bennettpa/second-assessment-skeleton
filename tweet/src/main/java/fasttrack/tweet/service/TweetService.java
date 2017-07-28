package fasttrack.tweet.service;

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
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tweet> getRepostById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tweet> getRepliesById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getMentionsById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getLikesById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HashTag> getTagsById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public TweetDto getTweetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public TweetDto post(ContentCredentialsDto inputDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void likeTweetById(CredentialsDto inputDto, String id) {
		// TODO Auto-generated method stub

	}

	public TweetDto repostTweetById(CredentialsDto inputDto, String id) {
		return null;
		// TODO Auto-generated method stub

	}

	public TweetDto replyTweetById(ContentCredentialsDto inputDto, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tweet deleteTweet(CredentialsDto inputDto, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
