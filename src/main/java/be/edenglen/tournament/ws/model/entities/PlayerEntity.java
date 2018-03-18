package be.edenglen.tournament.ws.model.entities;

import be.edenglen.tournament.ws.model.ChampionshipLevel;
import be.edenglen.tournament.ws.model.Player;
import be.edenglen.tournament.ws.model.Sex;
import be.edenglen.tournament.ws.model.SkillLevel;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class PlayerEntity implements Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String firstName;
    private String email;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;
    private String phone;
    @Enumerated(EnumType.STRING)
    private ChampionshipLevel championshipLevel;

    private PlayerEntity() {
        //jpa only
    }

    public PlayerEntity(Player player) {
        this.name = player.getName();
        this.firstName = player.getFirstName();
        this.email = player.getEmail();
        this.age = player.getAge();
        this.sex = player.getSex();
        this.skillLevel = player.getSkillLevel();
        this.phone = player.getPhone();
        this.championshipLevel = player.getChampionshipLevel();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public Sex getSex() {
        return this.sex;
    }

    @Override
    public SkillLevel getSkillLevel() {
        return this.skillLevel;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public ChampionshipLevel getChampionshipLevel() {
        return this.championshipLevel;
    }
}
