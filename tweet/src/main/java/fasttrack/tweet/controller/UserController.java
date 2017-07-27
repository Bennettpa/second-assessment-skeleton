package fasttrack.tweet.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fasttrack.tweet.dto.CredentialsProfileDto;
import fasttrack.tweet.dto.UserDto;
import fasttrack.tweet.entity.User;
import fasttrack.tweet.entity.Tweet;
import fasttrack.tweet.service.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/@{username}")
	@ApiOperation(value = "", nickname = "getUserByUsername")
	public UserDto getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	
	@GetMapping("/@{username}/feed")
	@ApiOperation(value = "", nickname = "getFeedByUsername")
	public List<Tweet> getFeedByUsername(@PathVariable String username) {
		return userService.getFeedByUsername(username);
	}
	
	@GetMapping("/@{username}/mentions")
	@ApiOperation(value = "", nickname = "getMentionsByUsername")
	public List<Tweet> getMentionsByUsername(@PathVariable String username) {
		return userService.getMentionsByUsername(username);
	}
	
	@GetMapping("/@{username}/followers")
	@ApiOperation(value = "", nickname = "getFollowersByUsername")
	public List<User> getFollowersByUsername(@PathVariable String username) {
		return userService.getFollowersByUsername(username);
	}
	
	@GetMapping("/@{username}/following")
	@ApiOperation(value = "", nickname = "getFollowingByUsername")
	public List<User> getFollowingByUsername(@PathVariable String username) {
		return userService.getFollowingByUsername(username);
	}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "postUser")
	public UserDto post(@RequestBody @Validated CredentialsProfileDto inputDto, HttpServletResponse httpResponse) {
		UserDto user = userService.post(inputDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return user;
	}

}
