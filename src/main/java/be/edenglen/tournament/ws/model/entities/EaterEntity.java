package be.edenglen.tournament.ws.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.Inscription;

@Entity
@Table(name = "eaters")
public class EaterEntity implements Eater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private InscriptionEntity inscription;

    private String name;
    private String firstName;
    private Integer age;
    private String email;

    private EaterEntity() {
        //JPA only
    }

    public EaterEntity(Eater eater, InscriptionEntity inscription) {
        this.id = eater.getId();
        this.inscription = inscription;
        this.name = eater.getName();
        this.firstName = eater.getFirstName();
        this.age = eater.getAge();
        this.email = eater.getEmail();
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
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getEmail() {
        return this.email;
    }
}
