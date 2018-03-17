package be.edenglen.tournament.ws.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Player {
    Long getId();
    String getName();
    String getFirstName();
    String getEmail();
    Integer getAge();
    Sex getSex();
    SkillLevel getSkillLevel();
    String getPhone();
    ChampionshipLevel getChampionshipLevel();
}
