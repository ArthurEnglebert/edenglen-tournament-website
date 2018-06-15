package be.edenglen.tournament.ws.www.dto.in;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(as = ImmutableHelperInDTO.class)
public interface HelperInDTO {
    String getName();
    String getFirstName();
    String getPhone();

    boolean isBringingFood();

    boolean isComingToBuild();
    @Nullable
    Integer getComingToBuildStart();
    @Nullable
    Integer getComingToBuildEnd();


    boolean isComingToDecorate();
    @Nullable
    Integer getComingToDecorateStart();
    @Nullable
    Integer getComingToDecorateEnd();

    boolean isComingToUnBuild();
    @Nullable
    Integer getComingToUnBuildStart();
    @Nullable
    Integer getComingToUnBuildEnd();

    Integer getNumberComing();
}
