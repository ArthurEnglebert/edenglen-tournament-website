package be.edenglen.tournament.ws.www.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableEaterInDTO.class)
public interface EaterInDTO {
    String getName();
    String getFirstName();
    Integer getAge();
}
