package be.edenglen.tournament.ws.www.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

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
