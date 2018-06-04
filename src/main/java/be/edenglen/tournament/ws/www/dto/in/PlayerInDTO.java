package be.edenglen.tournament.ws.www.dto.in;

import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import be.edenglen.tournament.ws.model.ChampionshipLevel;
import be.edenglen.tournament.ws.model.Sex;
import be.edenglen.tournament.ws.model.SkillLevel;

@Value.Immutable
@JsonDeserialize(as = ImmutablePlayerInDTO.class)
public interface PlayerInDTO {
    String getName();
    String getFirstName();
    String getEmail();
    Integer getAge();
    Sex getSex();
    SkillLevel getSkillLevel();
    String getPhone();
    ChampionshipLevel getChampionshipLevel();
    boolean isDining();
}
