package fasttrack.tweet.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name = "tweet_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Embedded
	@Cascade({CascadeType.ALL})
	private Credentials credentials;
	
	@OneToOne
	@Cascade({CascadeType.ALL})
	private Profile profile;
	
	@Cascade({CascadeType.ALL})
	private Timestamp joined;
	
	@ManyToMany
	@Cascade({CascadeType.ALL})
	private Set<User> following = new HashSet<User>();
	
	@ManyToMany
	@Cascade({CascadeType.ALL})
	private Set<User> followers = new HashSet<User>();
	
	// False if the users has been "DELETED"
	@Cascade({CascadeType.ALL})
	private boolean active= true;
	
	@OneToMany(mappedBy = "author")
	@Cascade({CascadeType.ALL})
	private Set<Tweet> tweets = new HashSet<Tweet>();
	
	@ManyToMany
	@Cascade({CascadeType.ALL})
	private Set<Tweet> mentions = new HashSet<Tweet>();
	
	@ManyToMany
	@Cascade({CascadeType.ALL})
	private Set<Tweet> likes = new HashSet<Tweet>();
	
	public User() {
		this.joined= new Timestamp(System.currentTimeMillis());
	}

	/**
	 * @return the credentials
	 */
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}


	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the joined
	 */
	public Timestamp getJoined() {
		return joined;
	}

	/**
	 * @param joined the joined to set
	 */
	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * @return the following
	 */
	public Set<User> getFollowing() {
		return following;
	}

	/**
	 * @param following the following to set
	 */
	public void setFollowing(Set<User> following) {
		this.following = following;
	}

	/**
	 * @return the tweets
	 */
	public Set<Tweet> getTweets() {
		return tweets;
	}

	/**
	 * @param tweets the tweets to set
	 */
	public void setTweets(Set<Tweet> tweets) {
		this.tweets = tweets;
	}

	/**
	 * @return the mentions
	 */
	public Set<Tweet> getMentions() {
		return mentions;
	}

	/**
	 * @param mentions the mentions to set
	 */
	public void setMentions(Set<Tweet> mentions) {
		this.mentions = mentions;
	}

	/**
	 * @return the followers
	 */
	public Set<User> getFollowers() {
		return followers;
	}

	/**
	 * @param followers the followers to set
	 */
	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}

	/**
	 * @return the likes
	 */
	public Set<Tweet> getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(Set<Tweet> likes) {
		this.likes = likes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	/* (non-Javadoc)
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
