package fasttrack.tweet.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fasttrack.tweet.dto.ContentCredentialsDto;
import fasttrack.tweet.dto.CredentialsDto;
import fasttrack.tweet.dto.TweetDto;
import fasttrack.tweet.entity.HashTag;
import fasttrack.tweet.entity.Tweet;
import fasttrack.tweet.entity.User;
import fasttrack.tweet.service.TweetService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("tweets")
public class TweetController {

	private TweetService tweetService;

	public TweetController(TweetService tweetService) {
		super();
		this.tweetService = tweetService;
	}
	
	@GetMapping
	@ApiOperation(value = "", nickname = "getAllTweets")
	public List<Tweet> getAllTweets() {
		return tweetService.getAllTweets();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "", nickname = "getTweetById")
	public TweetDto getTweetById(@PathVariable String id) {
		return tweetService.getTweetById(id);
	}
	
	@GetMapping("/{id}/reposts")
	@ApiOperation(value = "", nickname = "getRepostById")
	public List<Tweet> getRepostById(@PathVariable String id) {
		return tweetService.getRepostById(id);
	}
	
	@GetMapping("/{id}/replies")
	@ApiOperation(value = "", nickname = "getRepliesById")
	public List<Tweet> getRepliesById(@PathVariable String id) {
		return tweetService.getRepliesById(id);
	}
	
	@GetMapping("/{id}/mentions")
	@ApiOperation(value = "", nickname = "getMentionsById")
	public List<User> getMentionsById(@PathVariable String id) {
		return tweetService.getMentionsById(id);
	}
	
	@GetMapping("/{id}/likes")
	@ApiOperation(value = "", nickname = "getLikesById")
	public List<User> getLikesById(@PathVariable String id) {
		return tweetService.getLikesById(id);
	}
	
	@GetMapping("/{id}/tags")
	@ApiOperation(value = "", nickname = "getTagsById")
	public List<HashTag> getTagsById(@PathVariable String id) {
		return tweetService.getTagsById(id);
	}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "postTweet")
	public TweetDto post(@RequestBody @Validated ContentCredentialsDto inputDto, HttpServletResponse httpResponse) {
		TweetDto tweet = tweetService.post(inputDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return tweet;
	}
	
	@PostMapping("/{id}/like")
	@ApiOperation(value = "", nickname = "likeTweetById")
	public void likeTweetById(@RequestBody @Validated CredentialsDto inputDto, @PathVariable String id, HttpServletResponse httpResponse) {
		tweetService.likeTweetById(inputDto, id);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
	}
	
	@PostMapping("/{id}/repost")
	@ApiOperation(value = "", nickname = "repostTweetById")
	public TweetDto repostTweetById(@RequestBody @Validated CredentialsDto inputDto, @PathVariable String id, HttpServletResponse httpResponse) {
		TweetDto tweet = tweetService.repostTweetById(inputDto, id);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return tweet;
	}
	
	@PostMapping("/{id}/reply")
	@ApiOperation(value = "", nickname = "replyTweetById")
	public TweetDto replyTweetById(@RequestBody @Validated ContentCredentialsDto inputDto, @PathVariable String id, HttpServletResponse httpResponse) {
		TweetDto tweet = tweetService.replyTweetById(inputDto, id);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return tweet;
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "", nickname = "deleteTweet")
	public Tweet deleteTweet(@RequestBody @Validated CredentialsDto inputDto, @PathVariable String id, HttpServletResponse httpResponse) {
		Tweet tweet = tweetService.deleteTweet(inputDto, id);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return tweet;
	}
}
