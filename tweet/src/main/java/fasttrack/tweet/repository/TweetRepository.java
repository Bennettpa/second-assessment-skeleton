package fasttrack.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fasttrack.tweet.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
	List<Tweet> findByActiveAndTags_LabelEquals(boolean active, String label);
	List<Tweet> findByActiveAndAuthor_Credentials_UsernameEquals(boolean active, String username);
}
