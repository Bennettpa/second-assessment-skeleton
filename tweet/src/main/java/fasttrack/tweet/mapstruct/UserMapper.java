package fasttrack.tweet.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import fasttrack.tweet.dto.CredentialsDto;
import fasttrack.tweet.dto.ProfileDto;
import fasttrack.tweet.dto.UserDto;
import fasttrack.tweet.entity.Credentials;
import fasttrack.tweet.entity.Profile;
import fasttrack.tweet.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	ProfileDto toProfileDto(Profile profile);
	Profile toProfile(ProfileDto profile);
	
	CredentialsDto toCredentialsDto(Credentials credentials);
	Credentials toCredentials(CredentialsDto credentials);
	@Mappings({ 
		@Mapping(source = "credentials.username", target = "username")
		})
	UserDto toDto(User user);
	
}
