package fasttrack.tweet.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tweet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private User author;

	private Timestamp posted;
	private String content;

	@ManyToOne
	private Tweet inReplyTo;

	@OneToMany
	private Set<Tweet> replies = new HashSet<Tweet>();

	@ManyToOne
	private Tweet repostof;

	@OneToMany
	private Set<Tweet> reposts = new HashSet<Tweet>();

	private boolean active = true;

	@ManyToMany
	private Set<User> mentions = new HashSet<User>();

	@ManyToMany
	private Set<Tweet> likes = new HashSet<Tweet>();

	@ManyToMany
	private Set<HashTag> tags = new HashSet<HashTag>();

	public Tweet() {
		this.posted = new Timestamp(System.currentTimeMillis());
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
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
	 * @param posted
	 *            the posted to set
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
	 * @param content
	 *            the content to set
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
	 * @param inReplyTo
	 *            the inReplyTo to set
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
	 * @param repostof
	 *            the repostof to set
	 */
	public void setRepostof(Tweet repostof) {
		this.repostof = repostof;
	}

	/**
	 * @return the replys
	 */
	public Set<Tweet> getReplys() {
		return replies;
	}

	/**
	 * @param replys
	 *            the replys to set
	 */
	public void setReplys(Set<Tweet> replys) {
		this.replies = replys;
	}

	/**
	 * @return the reposts
	 */
	public Set<Tweet> getReposts() {
		return reposts;
	}

	/**
	 * @param reposts
	 *            the reposts to set
	 */
	public void setReposts(Set<Tweet> reposts) {
		this.reposts = reposts;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the mentions
	 */
	public Set<User> getMentions() {
		return mentions;
	}

	/**
	 * @param mentions
	 *            the mentions to set
	 */
	public void setMentions(Set<User> mentions) {
		this.mentions = mentions;
	}

	/**
	 * @return the likes
	 */
	public Set<Tweet> getLikes() {
		return likes;
	}

	/**
	 * @param likes
	 *            the likes to set
	 */
	public void setLikes(Set<Tweet> likes) {
		this.likes = likes;
	}

	/**
	 * @return the tags
	 */
	public Set<HashTag> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(Set<HashTag> tags) {
		this.tags = tags;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
