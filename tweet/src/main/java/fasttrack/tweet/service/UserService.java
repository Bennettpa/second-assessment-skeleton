package fasttrack.tweet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fasttrack.tweet.dto.CredentialsProfileDto;
import fasttrack.tweet.dto.UserDto;
import fasttrack.tweet.entity.Credentials;
import fasttrack.tweet.entity.Profile;
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

	public UserDto post(CredentialsProfileDto inputDto) {
		User user = new User();
		Profile profile = usermapper.toProfile(inputDto.getProfile());
		System.out.println("FirstName: "+profile.getFirstName());
		Credentials credentials = usermapper.toCredentials(inputDto.getCredentials());
		user.setCredentials(credentials);
		user.setProfile(profile);
		userrepo.save(user);
		return usermapper.toDto(user);
	}

}
