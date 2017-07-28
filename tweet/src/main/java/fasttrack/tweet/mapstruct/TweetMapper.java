package fasttrack.tweet.mapstruct;

import org.mapstruct.Mapper;

import fasttrack.tweet.dto.TweetDto;
import fasttrack.tweet.entity.Tweet;

@Mapper(componentModel = "spring")
public interface TweetMapper {
	TweetDto toDto(Tweet tweet);

	Tweet toTweet(TweetDto tweetById);
}
