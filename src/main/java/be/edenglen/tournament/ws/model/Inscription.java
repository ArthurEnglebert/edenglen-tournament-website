package be.edenglen.tournament.ws.model;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface Inscription {
    boolean DEFAULT_PAID_STATUS = false;

    Long getId();

    String getName();
    String getFirstName();
    String getEmail();
    String getPhone();

    List<Player> getPlayers();
    List<Eater> getEaters();

    Integer getDonation();

    @Value.Default
    default boolean isPaid() {
        return DEFAULT_PAID_STATUS;
    }
}
