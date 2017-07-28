package fasttrack.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fasttrack.tweet.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByCredentials_UsernameEquals(String username);

	User findByCredentials_UsernameEqualsAndCredentials_PasswordEquals(String username, String password);

	User findByActiveAndCredentials_UsernameEquals(boolean active, String username);
	
	List<User> findByActiveEquals(boolean active);
	
	List<User> findFollowingByActiveAndCredentials_UsernameEquals(boolean active, String username);

	List<User> findFollowersByActiveAndCredentials_UsernameEquals(boolean active, String username);
	
}
