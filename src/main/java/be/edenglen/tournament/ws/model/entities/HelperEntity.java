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

    private boolean isComingToBuild;
    private Integer comingToBuildStart;
    private Integer comingToBuildEnd;

    private boolean isComingToDecorate;
    private Integer comingToDecorateStart;
    private Integer comingToDecorateEnd;

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
        this.isComingToBuild = helper.isComingToBuild();
        this.comingToBuildStart = helper.getComingToBuildStart();
        this.comingToBuildEnd = helper.getComingToBuildEnd();
        this.isComingToDecorate = helper.isComingToDecorate();
        this.comingToDecorateStart = helper.getComingToDecorateStart();
        this.comingToDecorateEnd = helper.getComingToDecorateEnd();
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
    public boolean isComingToBuild() {
        return this.isComingToBuild;
    }

    @Override
    public Integer getComingToBuildStart() {
        return this.comingToBuildStart;
    }

    @Override
    public Integer getComingToBuildEnd() {
        return this.comingToBuildEnd;
    }

    @Override
    public boolean isComingToDecorate() {
        return this.isComingToDecorate;
    }

    @Override
    public Integer getComingToDecorateStart() {
        return this.comingToDecorateStart;
    }

    @Override
    public Integer getComingToDecorateEnd() {
        return this.comingToDecorateEnd;
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
