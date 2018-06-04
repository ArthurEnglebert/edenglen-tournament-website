package be.edenglen.tournament.ws.www.dto.in;

import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(as = ImmutableEaterInDTO.class)
public interface EaterInDTO {
    String getName();
    String getFirstName();
    Integer getAge();
    String getEmail();
}
