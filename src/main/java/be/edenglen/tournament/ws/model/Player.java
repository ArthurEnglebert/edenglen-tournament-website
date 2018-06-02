package be.edenglen.tournament.ws.model;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

@Value.Immutable
public interface Player {
    @Nullable
    Long getId();
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
