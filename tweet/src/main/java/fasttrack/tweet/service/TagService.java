package fasttrack.tweet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fasttrack.tweet.entity.HashTag;
import fasttrack.tweet.entity.Tweet;
import fasttrack.tweet.mapstruct.TagMapper;
import fasttrack.tweet.mapstruct.TweetMapper;
import fasttrack.tweet.repository.TagRepository;
import fasttrack.tweet.repository.TweetRepository;

@Service
public class TagService {
	private TagRepository tagrepo;
	private TweetRepository tweetrepo;

	public TagService(TagMapper tagmapper, TagRepository tagrepo, TweetMapper tweetmapper, TweetRepository tweetrepo) {
		this.tagrepo = tagrepo;
		this.tweetrepo = tweetrepo;
	}

	public List<HashTag> getAllTags() {
		return tagrepo.findAll();
	}

	public List<Tweet> getTweetsByLabel(String label) {
		return tweetrepo.findByActiveAndTags_LabelEquals(true, label);
	}

}
