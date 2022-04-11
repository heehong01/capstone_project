package com.example.backend_capstone.jpa.enititymodels;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="garden")
public class Garden {
    @Id
    @Column(name="garden_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gardenId;

    @Column(name = "garden_name")
    private String gardenName;

    @Column(name="house_type")
    private String houseType;

    @OneToOne(targetEntity = GardenInfo.class)
    @JoinColumn(name="garden_type", referencedColumnName = "garden_name")
    private String gardenType;

    @OneToMany(targetEntity = Seeds.class, cascade = {CascadeType.ALL})
    @JoinTable(name="seeds_to_plant",
            joinColumns = @JoinColumn(name="seed_name"),
            inverseJoinColumns = @JoinColumn(name="gardenId"))
    private List<Seeds> seedType;

    public Garden() {
        this.seedType = new ArrayList<>();
    }

    public Garden(long gardenId, String gardenName, String houseType, String gardenType, List<Seeds> seedType) {
        this.gardenId = gardenId;
        this.gardenName = gardenName;
        this.houseType = houseType;
        this.gardenType = gardenType;
        this.seedType = seedType;
    }

    public long getGardenId() {
        return gardenId;
    }

    public void setGardenId(long gardenId) {
        this.gardenId = gardenId;
    }

    public String getGardenName() {
        return gardenName;
    }

    public void setGardenName(String gardenName) {
        this.gardenName = gardenName;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getGardenType() {
        return gardenType;
    }

    public void setGardenType(String gardenType) {
        this.gardenType = gardenType;
    }

    public List<Seeds> getSeedType() {
        return seedType;
    }

    public void setSeedType(List<Seeds> seedType) {
        this.seedType = seedType;
    }
}
