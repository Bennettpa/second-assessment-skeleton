package fasttrack.tweet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fasttrack.tweet.service.ValidateService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("validate")
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
