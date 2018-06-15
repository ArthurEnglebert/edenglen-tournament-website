package be.edenglen.tournament.ws.www.dto.stats;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableDisparityStatDTOOut.class)
public interface DisparityStatDTOOut {
    Integer getAbsoluteMenNumber();
    Integer getAbsoluteWomenNumber();
}
