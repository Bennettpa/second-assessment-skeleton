package fasttrack.tweet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fasttrack.tweet.entity.HashTag;
import fasttrack.tweet.entity.Tweet;
import fasttrack.tweet.service.TagService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("tags")
public class TagController {

	private TagService tagService;

	public TagController(TagService tagService) {
		super();
		this.tagService = tagService;
	}

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllTags")
	public List<HashTag> getAllTags() {
		return tagService.getAllTags();
	}

	@GetMapping("/{label}")
	@ApiOperation(value = "", nickname = "getTweetsByLabel")
	public List<Tweet> getTweetsByLabel(@PathVariable String label) {
		return tagService.getTweetsByLabel(label);
	}

}
