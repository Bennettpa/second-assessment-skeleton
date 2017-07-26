package fasttrack.tweet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import fasttrack.tweet.service.ValidateService;
import io.swagger.annotations.ApiOperation;

public class ValidateController {
	
	private ValidateService validateService;

	public ValidateController(ValidateService validateService) {
		this.validateService = validateService;
	}
	
	@GetMapping("tag/exists/{label}")
	@ApiOperation(value = "", nickname = "getTagExists")
	public boolean getTagExists(@PathVariable String label) {
		return validateService.getTagExists(label);
	}
	
	@GetMapping("username/exists/@{username}")
	@ApiOperation(value = "", nickname = "getUsernameExists")
	public boolean getUsernameExists(@PathVariable String username) {
		return validateService.getUsernameExists(username);
	}
	
	@GetMapping("username/available/@{username}")
	@ApiOperation(value = "", nickname = "getUsernameAvailable")
	public boolean getUsernameAvailable(@PathVariable String username) {
		return validateService.getUsernameAvailable(username);
	}

}
