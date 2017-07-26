package fasttrack.tweet.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fasttrack.tweet.dto.CredentialsProfileDto;
import fasttrack.tweet.dto.UserDto;
import fasttrack.tweet.service.UserService;
import io.swagger.annotations.ApiOperation;

public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllUsers")
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "postUser")
	public UserDto post(@RequestBody @Validated CredentialsProfileDto inputDto, HttpServletResponse httpResponse) {
		UserDto user = userService.post(inputDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return user;
	}

}
