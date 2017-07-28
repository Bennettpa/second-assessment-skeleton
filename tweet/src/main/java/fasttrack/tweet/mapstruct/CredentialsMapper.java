package fasttrack.tweet.mapstruct;

import org.mapstruct.Mapper;

import fasttrack.tweet.dto.CredentialsDto;
import fasttrack.tweet.entity.Credentials;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {

	CredentialsDto toCredentialsDto(Credentials credentials);

	CredentialsDto toProfile(CredentialsDto credentials);

}
