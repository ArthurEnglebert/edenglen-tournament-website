package be.edenglen.tournament.ws.www.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableRegisterInDTO.class)
public interface RegisterInDTO {
    String getName();
    String getFirstName();
    String getEmail();
    String getPhone();
}
