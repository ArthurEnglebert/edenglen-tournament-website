package be.edenglen.tournament.ws.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Helper {
    Long getId();
    String getName();
    String getFirstName();
    String getPhone();

    boolean isBringingFood();
    boolean isComingToBuild();
    boolean isComingToUnBuild();
    boolean isComingToDecorate();
}
