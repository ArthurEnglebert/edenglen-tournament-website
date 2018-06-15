package be.edenglen.tournament.ws.www.dto.in;

import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(as = ImmutableRegisterInDTO.class)
public interface RegisterInDTO {
    String getName();
    String getFirstName();
    String getEmail();
    String getPhone();
}
