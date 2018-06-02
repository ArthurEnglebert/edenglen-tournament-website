package be.edenglen.tournament.ws.www.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableInscriptionInDTO.class)
public interface InscriptionInDTO {
    RegisterInDTO getReferent();

    List<PlayerInDTO> getPlayers();

    List<EaterInDTO> getEaters();

    Integer getDonation();
}
