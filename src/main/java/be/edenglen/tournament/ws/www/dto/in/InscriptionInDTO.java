package be.edenglen.tournament.ws.www.dto.in;

import java.util.List;
import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(as = ImmutableInscriptionInDTO.class)
public interface InscriptionInDTO {
    RegisterInDTO getReferent();

    List<PlayerInDTO> getPlayers();

    List<EaterInDTO> getEaters();

    Integer getDonation();
}
