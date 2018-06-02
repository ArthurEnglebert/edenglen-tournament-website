package be.edenglen.tournament.ws.model;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

@Value.Immutable
public interface Eater {
    @Nullable
    Long getId();
    String getName();
    String getFirstName();
    Integer getAge();
    String getEmail();
}
