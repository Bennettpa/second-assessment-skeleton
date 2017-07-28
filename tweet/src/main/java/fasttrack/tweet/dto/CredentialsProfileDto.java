package fasttrack.tweet.dto;

import javax.persistence.Embedded;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class CredentialsProfileDto {

	@Embedded
	@Cascade({ CascadeType.ALL })
	private CredentialsDto credentials;

	@Embedded
	@Cascade({ CascadeType.ALL })
	private ProfileDto profile;

	/**
	 * @return the credentials
	 */
	public CredentialsDto getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials
	 *            the credentials to set
	 */
	public void setCredentials(CredentialsDto credentials) {
		this.credentials = credentials;
	}

	public ProfileDto getProfile() {
		return profile;
	}

	public void setProfile(ProfileDto profile) {
		this.profile = profile;
	}

}
