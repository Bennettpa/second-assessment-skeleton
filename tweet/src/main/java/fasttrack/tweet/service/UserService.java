package fasttrack.tweet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fasttrack.tweet.dto.CredentialsDto;
import fasttrack.tweet.dto.CredentialsProfileDto;
import fasttrack.tweet.dto.UserDto;
import fasttrack.tweet.entity.Credentials;
import fasttrack.tweet.entity.Profile;
import fasttrack.tweet.entity.Tweet;
import fasttrack.tweet.entity.User;
import fasttrack.tweet.mapstruct.UserMapper;
import fasttrack.tweet.repository.UserRepository;

@Service
public class UserService {
	
	private UserMapper usermapper;
	private UserRepository userrepo;
	
	public UserService(UserMapper usermapper, UserRepository userrepo) {
		super();
		this.usermapper = usermapper;
		this.userrepo = userrepo;
	}

	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

	public UserDto getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tweet> getFeedByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tweet> getMentionsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getFollowingByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getFollowersByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	public void unfollowUser(CredentialsDto inputDto, String username) {
		// TODO Auto-generated method stub
		
	}

	public User deleteUser(CredentialsDto inputDto, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public User updateUser(CredentialsProfileDto inputDto, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tweet> getTweetsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
