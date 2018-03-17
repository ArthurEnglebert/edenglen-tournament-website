package be.edenglen.tournament.ws.model.entities;

import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class InscriptionEntity implements Inscription {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String firstName;
    private String email;
    private String phone;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "inscriptions_players",
            joinColumns = @JoinColumn(name = "inscription_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "players_id", referencedColumnName = "id")
    )
    private List<Player> players;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "inscriptions_eaters",
            joinColumns = @JoinColumn(name = "inscription_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "eater_id", referencedColumnName = "id")
    )
    private List<Eater> eaters;

    private Integer donation;

    private InscriptionEntity() {
        //JPA ONLY
    }

    public InscriptionEntity(Inscription inscription) {
        this.name = inscription.getName();
        this.firstName = inscription.getFirstName();
        this.email = inscription.getEmail();
        this.phone = inscription.getPhone();
        this.players = new ArrayList<>(inscription.getPlayers());
        this.eaters = new ArrayList<>(inscription.getEaters());
        this.donation = inscription.getDonation();
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
    public String getPhone() {
        return this.phone;
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    @Override
    public List<Eater> getEaters() {
        return Collections.unmodifiableList(this.eaters);
    }

    @Override
    public Integer getDonation() {
        return this.donation;
    }
}
