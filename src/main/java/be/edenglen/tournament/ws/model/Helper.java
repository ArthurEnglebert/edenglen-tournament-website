package be.edenglen.tournament.ws.model;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

@Value.Immutable
public interface Helper {
    boolean DEFAULT_BRINGING_FOOD = false;
    boolean DEFAULT_COMING_BUILD = false;
    boolean DEFAULT_COMING_UNBUILD = false;
    boolean DEFAULT_COMING_TO_DECORATE = false;

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
    @Value.Default
    default boolean isComingToUnBuild() {
        return DEFAULT_COMING_UNBUILD;
    }
    @Value.Default
    default boolean isComingToDecorate() {
        return DEFAULT_COMING_TO_DECORATE;
    }

    Integer getNumberComing();
}
