package be.edenglen.tournament.ws.www.dto;

import be.edenglen.tournament.ws.model.ChampionshipLevel;
import be.edenglen.tournament.ws.model.Sex;
import be.edenglen.tournament.ws.model.SkillLevel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

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
}
