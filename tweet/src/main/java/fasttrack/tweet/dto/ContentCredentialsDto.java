package fasttrack.tweet.dto;

import javax.persistence.Embedded;

import fasttrack.tweet.entity.Credentials;

public class ContentCredentialsDto {
	private String content;

	@Embedded
	private Credentials credentials;

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
	 * @return the credentials
	 */
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials
	 *            the credentials to set
	 */
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
}
