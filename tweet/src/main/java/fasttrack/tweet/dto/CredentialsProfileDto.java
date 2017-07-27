package fasttrack.tweet.dto;

import fasttrack.tweet.entity.Credentials;
import fasttrack.tweet.entity.Profile;

public class CredentialsProfileDto {

	private CredentialsDto credentials;
	
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
