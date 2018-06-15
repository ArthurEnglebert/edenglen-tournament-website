package be.edenglen.tournament.ws.model;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

@Value.Immutable
public interface Helper {
    boolean DEFAULT_BRINGING_FOOD = false;
    boolean DEFAULT_COMING_BUILD = false;
    boolean DEFAULT_COMING_DECORATE = false;
    boolean DEFAULT_COMING_UNBUILD = false;

    @Nullable
    Long getId();
    String getName();
    String getFirstName();
    String getPhone();

    @Value.Default
    default boolean isBringingFood() {
        return DEFAULT_BRINGING_FOOD;
    }

    @Value.Default
    default boolean isComingToBuild() {
        return DEFAULT_COMING_BUILD;
    }
    @Nullable
    Integer getComingToBuildStart();
    @Nullable
    Integer getComingToBuildEnd();

    @Value.Default
    default boolean isComingToDecorate() {
        return DEFAULT_COMING_DECORATE;
    }
    @Nullable
    Integer getComingToDecorateStart();
    @Nullable
    Integer getComingToDecorateEnd();

    @Value.Default
    default boolean isComingToUnBuild() {
        return DEFAULT_COMING_UNBUILD;
    }
    @Nullable
    Integer getComingToUnBuildStart();
    @Nullable
    Integer getComingToUnBuildEnd();

    Integer getNumberComing();
}
