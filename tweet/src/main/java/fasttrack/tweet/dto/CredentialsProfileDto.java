package fasttrack.tweet.dto;

import javax.persistence.Embedded;

public class CredentialsProfileDto {
	
	@Embedded
	private CredentialsDto credentials;
	
	@Embedded
	private ProfileDto profile;

	/**
	 * @return the credentials
	 */
	public CredentialsDto getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials the credentials to set
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
