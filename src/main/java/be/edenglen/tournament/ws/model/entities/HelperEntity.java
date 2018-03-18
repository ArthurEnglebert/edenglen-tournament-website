package be.edenglen.tournament.ws.model.entities;

import be.edenglen.tournament.ws.model.Helper;

import javax.persistence.*;

@Entity
@Table(name = "helpers")
public class HelperEntity implements Helper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String firstName;
    private String phone;
    private boolean isBringingFood;
    private boolean isComingToBuild;
    private boolean isComingToUnBuild;
    private boolean isComingToDecorate;

    private HelperEntity() {
        //JPA ONLY
    }

    public HelperEntity(Helper helper) {
        this.name = helper.getName();
        this.firstName = helper.getFirstName();
        this.phone = helper.getPhone();
        this.isBringingFood = helper.isBringingFood();
        this.isComingToBuild = helper.isComingToBuild();
        this.isComingToUnBuild = helper.isComingToUnBuild();
        this.isComingToDecorate = helper.isComingToDecorate();
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
    public String getPhone() {
        return this.phone;
    }

    @Override
    public boolean isBringingFood() {
        return this.isBringingFood;
    }

    @Override
    public boolean isComingToBuild() {
        return this.isComingToBuild;
    }

    @Override
    public boolean isComingToUnBuild() {
        return this.isComingToUnBuild;
    }

    @Override
    public boolean isComingToDecorate() {
        return this.isComingToDecorate;
    }
}
