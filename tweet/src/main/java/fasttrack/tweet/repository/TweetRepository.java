package fasttrack.tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fasttrack.tweet.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer>{

}
