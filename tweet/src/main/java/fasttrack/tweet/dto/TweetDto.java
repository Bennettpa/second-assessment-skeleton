package fasttrack.tweet.dto;

import java.sql.Timestamp;

import fasttrack.tweet.entity.Tweet;
import fasttrack.tweet.entity.User;

public class TweetDto {

	private User author;
	private Timestamp posted;
	private String content;
	private Tweet inReplyTo;
	private Tweet repostof;
	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}
	/**
	 * @return the posted
	 */
	public Timestamp getPosted() {
		return posted;
	}
	/**
	 * @param posted the posted to set
	 */
	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the inReplyTo
	 */
	public Tweet getInReplyTo() {
		return inReplyTo;
	}
	/**
	 * @param inReplyTo the inReplyTo to set
	 */
	public void setInReplyTo(Tweet inReplyTo) {
		this.inReplyTo = inReplyTo;
	}
	/**
	 * @return the repostof
	 */
	public Tweet getRepostof() {
		return repostof;
	}
	/**
	 * @param repostof the repostof to set
	 */
	public void setRepostof(Tweet repostof) {
		this.repostof = repostof;
	}
}
