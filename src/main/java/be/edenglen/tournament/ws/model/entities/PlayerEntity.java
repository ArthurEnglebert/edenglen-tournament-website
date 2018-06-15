package be.edenglen.tournament.ws.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import be.edenglen.tournament.ws.model.ChampionshipLevel;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;
import be.edenglen.tournament.ws.model.Sex;
import be.edenglen.tournament.ws.model.SkillLevel;

@Entity
@Table(name = "players")
public class PlayerEntity implements Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private InscriptionEntity inscription;

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
    private boolean isDining;

    private PlayerEntity() {
        //jpa only
    }

    public PlayerEntity(Player player, InscriptionEntity inscription) {
        this.id = player.getId();
        this.inscription = inscription;
        this.name = player.getName();
        this.firstName = player.getFirstName();
        this.email = player.getEmail();
        this.age = player.getAge();
        this.sex = player.getSex();
        this.skillLevel = player.getSkillLevel();
        this.phone = player.getPhone();
        this.championshipLevel = player.getChampionshipLevel();
        this.isDining = player.isDining();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Inscription getInscription() {
        return this.inscription;
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

    @Override
    public boolean isDining() {
        return this.isDining;
    }
}
