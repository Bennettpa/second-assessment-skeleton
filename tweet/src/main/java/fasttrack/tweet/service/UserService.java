package fasttrack.tweet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fasttrack.tweet.dto.CredentialsDto;
import fasttrack.tweet.dto.CredentialsProfileDto;
import fasttrack.tweet.dto.TweetDto;
import fasttrack.tweet.dto.UserDto;
import fasttrack.tweet.entity.Credentials;
import fasttrack.tweet.entity.Profile;
import fasttrack.tweet.entity.Tweet;
import fasttrack.tweet.entity.User;
import fasttrack.tweet.exception.InvaildUsernameException;
import fasttrack.tweet.mapstruct.TweetMapper;
import fasttrack.tweet.mapstruct.UserMapper;
import fasttrack.tweet.repository.TweetRepository;
import fasttrack.tweet.repository.UserRepository;

@Service
public class UserService {

	private UserMapper usermapper;
	private UserRepository userrepo;
	private TweetMapper tweetmapper;
	private TweetRepository tweetrepo;

	

	public UserService(UserMapper usermapper, UserRepository userrepo, TweetMapper tweetmapper,
			TweetRepository tweetrepo) {
		super();
		this.usermapper = usermapper;
		this.userrepo = userrepo;
		this.tweetmapper = tweetmapper;
		this.tweetrepo = tweetrepo;
	}

	public List<UserDto> getAllUsers() {
		return userrepo.findByActiveEquals(true).stream().map(usermapper::toDto).collect(Collectors.toList());
	}

	public UserDto getUserByUsername(String username) throws InvaildUsernameException {
		if(userrepo.findByActiveAndCredentials_UsernameEquals(true, username)== null)throw(new InvaildUsernameException("The username is invaild."));
		return usermapper.toDto(userrepo.findByActiveAndCredentials_UsernameEquals(true, username));
	}

	public List<TweetDto> getFeedByUsername(String username) {
		List<TweetDto> tweets = getTweetsByUsername(username);
		List<User> following = getFollowingByUsername(username);
		for(User user : following){
			tweets.addAll(getTweetsByUsername(user.getCredentials().getUsername()));
		}
		return tweets;
	}

	public List<TweetDto> getMentionsByUsername(String username) {
		Set<Tweet> mentions = userrepo.findByActiveAndCredentials_UsernameEquals(true, username).getMentions();
		List<Tweet> results = new ArrayList<Tweet>();
		for(Tweet tweet : mentions){
			if(tweet.isActive()) results.add(tweet);
		}
		return results.stream().map(tweetmapper::toDto).collect(Collectors.toList());
	}

	public List<User> getFollowingByUsername(String username) {
		return userrepo.findFollowingByActiveAndCredentials_UsernameEquals(true, username);
	}

	public List<User> getFollowersByUsername(String username) {
		return userrepo.findFollowersByActiveAndCredentials_UsernameEquals(true, username);
	}

	public UserDto post(CredentialsProfileDto inputDto) {
		User user = new User();
		Profile profile = usermapper.toProfile(inputDto.getProfile());
		Credentials credentials = usermapper.toCredentials(inputDto.getCredentials());
		user.setCredentials(credentials);
		user.setProfile(profile);
		userrepo.save(user);
		return usermapper.toDto(user);
	}

	public void followUser(CredentialsDto inputDto, String username) {
		User user = userrepo.findByActiveAndCredentials_UsernameEquals(true, inputDto.getUsername());
		user.getFollowing().add(userrepo.findByActiveAndCredentials_UsernameEquals(true, username));
		userrepo.save(user);
	}

	public void unfollowUser(CredentialsDto inputDto, String username) {
		User user = userrepo.findByActiveAndCredentials_UsernameEquals(true, inputDto.getUsername());
		user.getFollowing().remove(userrepo.findByActiveAndCredentials_UsernameEquals(true, username));
		userrepo.save(user);
	}

	public User deleteUser(CredentialsDto inputDto, String username) {
		User user = userrepo.findByActiveAndCredentials_UsernameEquals(true, inputDto.getUsername());
		user.setActive(false);
		userrepo.save(user);
		return user;
	}

	public User updateUser(CredentialsProfileDto inputDto, String username) {
		User user = userrepo.findByActiveAndCredentials_UsernameEquals(true, username);
		if(user.getCredentials().getUsername()==username) {
			user.setProfile(usermapper.toProfile(inputDto.getProfile()));
			user.setCredentials(usermapper.toCredentials(inputDto.getCredentials()));
			userrepo.save(user);
		}
		return user;
	}

	public List<TweetDto> getTweetsByUsername(String username) {
		
		return tweetrepo.findByActiveAndAuthor_Credentials_UsernameEquals(true, username).stream().map(tweetmapper::toDto).collect(Collectors.toList());
	}

}
