package be.edenglen.tournament.ws.www.dto.stats;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableAwaitedAmountDTOOut.class)
public interface AwaitedAmountDTOOut {
    Integer getTotal();

    Integer getFromTennis();
    Integer getFromDinners();
    Integer getFromDonations();
}