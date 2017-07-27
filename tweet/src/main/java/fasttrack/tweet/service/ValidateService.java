package fasttrack.tweet.service;

import org.springframework.stereotype.Service;

import fasttrack.tweet.mapstruct.TagMapper;
import fasttrack.tweet.mapstruct.UserMapper;
import fasttrack.tweet.repository.TagRepository;
import fasttrack.tweet.repository.UserRepository;

@Service
public class ValidateService {
	
	private UserMapper usermapper;
	private UserRepository userrepo;
	private TagMapper tagmapper;
	private TagRepository tagrepo;

	public ValidateService(UserMapper usermapper, UserRepository userrepo, TagMapper tagmapper, TagRepository tagrepo) {
		this.usermapper = usermapper;
		this.userrepo = userrepo;
		this.tagmapper = tagmapper;
		this.tagrepo = tagrepo;
	}

	public boolean getTagExists(String label) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getUsernameExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getUsernameAvailable(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
