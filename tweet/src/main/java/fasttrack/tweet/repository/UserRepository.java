package fasttrack.tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fasttrack.tweet.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByCredentials_UsernameEquals(String username);
	User findByCredentials_UsernameEqualsAndCredentials_PasswordEquals(String username, String password);
}
