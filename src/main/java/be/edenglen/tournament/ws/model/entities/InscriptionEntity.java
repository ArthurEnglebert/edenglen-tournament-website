package be.edenglen.tournament.ws.model.entities;

import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "inscriptions")
public class InscriptionEntity implements Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String firstName;
    private String email;
    private String phone;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "inscriptions_players",
            joinColumns = @JoinColumn(name = "inscription_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id")
    )
    private List<PlayerEntity> players;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "inscriptions_eaters",
            joinColumns = @JoinColumn(name = "inscription_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "eater_id", referencedColumnName = "id")
    )
    private List<EaterEntity> eaters;

    private Integer donation;

    private boolean isPaid;

    private InscriptionEntity() {
        //JPA ONLY
    }

    public InscriptionEntity(Inscription inscription) {
        this.name = inscription.getName();
        this.firstName = inscription.getFirstName();
        this.email = inscription.getEmail();
        this.phone = inscription.getPhone();
        this.players = inscription.getPlayers().stream().map(PlayerEntity::new).collect(Collectors.toList());
        this.eaters = inscription.getEaters().stream().map(EaterEntity::new).collect(Collectors.toList());
        this.donation = inscription.getDonation();
        this.isPaid = inscription.isPaid();
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

    @Override
    public boolean isPaid() {
        return this.isPaid;
    }
}
