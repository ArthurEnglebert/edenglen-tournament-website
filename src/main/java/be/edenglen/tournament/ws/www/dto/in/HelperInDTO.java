package be.edenglen.tournament.ws.www.dto.in;

import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(as = ImmutableHelperInDTO.class)
public interface HelperInDTO {
    String getName();
    String getFirstName();
    String getPhone();

    boolean isBringingFood();
    boolean isComingToBuild();
    boolean isComingToUnBuild();
    boolean isComingToDecorate();

    Integer getNumberComing();
}
