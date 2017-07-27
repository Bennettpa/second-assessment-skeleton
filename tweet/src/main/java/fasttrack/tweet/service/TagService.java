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
	private TagMapper tagmapper;
	private TagRepository tagrepo;
	private TweetMapper tweetmapper;
	private TweetRepository tweetrepo;
	
	
	public TagService(TagMapper tagmapper, TagRepository tagrepo, TweetMapper tweetmapper, TweetRepository tweetrepo) {
		super();
		this.tagmapper = tagmapper;
		this.tagrepo = tagrepo;
		this.tweetmapper = tweetmapper;
		this.tweetrepo = tweetrepo;
	}

	public List<HashTag> getAllTags() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tweet> getTweetsByLabel(String label) {
		// TODO Auto-generated method stub
		return null;
	}

}
