package be.edenglen.tournament.ws.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Eater {
    Long getId();
    String getName();
    String getFirstName();
    Integer getAge();
}
