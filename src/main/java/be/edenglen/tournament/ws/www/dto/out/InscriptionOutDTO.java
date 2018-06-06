package be.edenglen.tournament.ws.www.dto.out;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

@Value.Immutable
public interface InscriptionOutDTO {
    @Nullable
    Long getId();
    String getFirstName();
    String getName();
    String getEmail();
    String getPhone();
    @Nullable
    Integer getAmount();
    boolean isPaid();
}
