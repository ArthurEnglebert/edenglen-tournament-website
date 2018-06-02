package be.edenglen.tournament.ws.model;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import java.util.List;

@Value.Immutable
public interface Inscription {
    boolean DEFAULT_PAID_STATUS = false;

    @Nullable
    Long getId();

    String getName();
    String getFirstName();
    String getEmail();
    String getPhone();

    List<Player> getPlayers();
    List<Eater> getEaters();

    @Nullable
    Integer getDonation();

    Integer getAmount();

    @Value.Default
    default boolean isPaid() {
        return DEFAULT_PAID_STATUS;
    }
}
