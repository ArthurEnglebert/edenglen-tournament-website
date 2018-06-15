package be.edenglen.tournament.ws.model.entities;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.Player;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "inscription")
    private List<PlayerEntity> players;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "inscription")
    private List<EaterEntity> eaters;

    private Integer donation;

    private Integer amount;
    private boolean isPaid;

    private InscriptionEntity() {
        //JPA ONLY
    }

    public InscriptionEntity(Inscription inscription) {
        this.id = inscription.getId();
        this.name = inscription.getName();
        this.firstName = inscription.getFirstName();
        this.email = inscription.getEmail();
        this.phone = inscription.getPhone();
        this.players = inscription.getPlayers().stream().map(player -> new PlayerEntity(player, this)).collect(Collectors.toList());
        this.eaters = inscription.getEaters().stream().map(eater -> new EaterEntity(eater, this)).collect(Collectors.toList());
        this.donation = inscription.getDonation();
        this.amount = inscription.getAmount();
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
    public Integer getAmount() {
        return this.amount;
    }

    @Override
    public boolean isPaid() {
        return this.isPaid;
    }
}
