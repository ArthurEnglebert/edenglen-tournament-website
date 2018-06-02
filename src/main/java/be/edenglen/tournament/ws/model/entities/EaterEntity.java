package be.edenglen.tournament.ws.model.entities;

import be.edenglen.tournament.ws.model.Eater;

import javax.persistence.*;

@Entity
@Table(name = "eaters")
public class EaterEntity implements Eater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String firstName;
    private Integer age;
    private String email;

    private EaterEntity() {
        //JPA only
    }

    public EaterEntity(Eater eater) {
        this.id = eater.getId();
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
