package fasttrack.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fasttrack.tweet.dto.TweetDto;
import fasttrack.tweet.entity.HashTag;
import fasttrack.tweet.entity.Tweet;
import fasttrack.tweet.entity.User;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
	List<Tweet> findByActiveAndTags_LabelEquals(boolean active, String label);
	List<Tweet> findByActiveAndAuthor_Credentials_UsernameEquals(boolean active, String username);
	List<Tweet> findByActiveEqualsOrderByPostedDesc(boolean active);
	Tweet findByActiveAndIdEquals(boolean active, String id);
	List<Tweet> findRepostsByActiveAndIdEquals(boolean b, String id);
	List<Tweet> findRepostsByActiveAndIdEqualsOrderByPostedDesc(boolean b, String id);
	List<Tweet> findRepliesByActiveAndIdEqualsOrderByPostedDesc(boolean b, String id);
	List<User> findMentionsByActiveAndIdEquals(boolean b, String id);
	List<User> findLikesByActiveAndIdEquals(boolean b, String id);
	List<HashTag> findTagsByActiveAndIdEquals(boolean b, String id);
}
