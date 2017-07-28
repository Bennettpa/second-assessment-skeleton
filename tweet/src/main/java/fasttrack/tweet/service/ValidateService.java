package fasttrack.tweet.service;

import org.springframework.stereotype.Service;

import fasttrack.tweet.mapstruct.TagMapper;
import fasttrack.tweet.mapstruct.UserMapper;
import fasttrack.tweet.repository.TagRepository;
import fasttrack.tweet.repository.UserRepository;

@Service
public class ValidateService {

	private UserRepository userrepo;
	private TagRepository tagrepo;

	public ValidateService(UserMapper usermapper, UserRepository userrepo, TagMapper tagmapper, TagRepository tagrepo) {
		this.userrepo = userrepo;
		this.tagrepo = tagrepo;
	}

	public boolean getTagExists(String label) {
		return tagrepo.findByLabelEquals(label) != null;
	}

	public boolean getUsernameExists(String username) {
		return userrepo.findByActiveAndCredentials_UsernameEquals(true, username) != null;
	}

	public boolean getUsernameAvailable(String username) {
		return userrepo.findByCredentials_UsernameEquals(username) == null;
	}

}
