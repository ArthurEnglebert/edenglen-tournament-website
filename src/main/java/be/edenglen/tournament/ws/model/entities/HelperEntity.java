package be.edenglen.tournament.ws.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import be.edenglen.tournament.ws.model.Helper;

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

    private boolean isComingToBuildAndDecorate;
    private Integer comingToBuildAndDecorateStart;
    private Integer comingToBuildAndDecorateEnd;

    private boolean isComingToUnBuild;
    private Integer comingToUnBuildStart;
    private Integer comingToUnBuildEnd;


    private Integer numberComing;

    private HelperEntity() {
        //JPA ONLY
    }

    public HelperEntity(Helper helper) {
        this.id = helper.getId();
        this.name = helper.getName();
        this.firstName = helper.getFirstName();
        this.phone = helper.getPhone();
        this.isBringingFood = helper.isBringingFood();
        this.isComingToBuildAndDecorate = helper.isComingToBuildAndDecorate();
        this.comingToBuildAndDecorateStart = helper.getComingToBuildAndDecorateStart();
        this.comingToBuildAndDecorateEnd = helper.getComingToBuildAndDecorateEnd();
        this.isComingToUnBuild = helper.isComingToUnBuild();
        this.comingToUnBuildStart = helper.getComingToUnBuildStart();
        this.comingToUnBuildEnd = helper.getComingToUnBuildEnd();
        this.numberComing = helper.getNumberComing();
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
    public boolean isComingToBuildAndDecorate() {
        return this.isComingToBuildAndDecorate;
    }

    @Override
    public Integer getComingToBuildAndDecorateStart() {
        return this.comingToBuildAndDecorateStart;
    }

    @Override
    public Integer getComingToBuildAndDecorateEnd() {
        return this.comingToBuildAndDecorateEnd;
    }

    @Override
    public boolean isComingToUnBuild() {
        return this.isComingToUnBuild;
    }

    @Override
    public Integer getComingToUnBuildStart() {
        return this.comingToUnBuildStart;
    }

    @Override
    public Integer getComingToUnBuildEnd() {
        return this.comingToUnBuildEnd;
    }

    @Override
    public Integer getNumberComing() {
        return this.numberComing;
    }
}
