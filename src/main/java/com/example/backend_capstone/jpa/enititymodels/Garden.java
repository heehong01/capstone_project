package com.example.backend_capstone.jpa.enititymodels;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="garden")
public class Garden {
    @Id
    @Column(name="garden_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gardenId;

    @Column(name="garden_name")
    private String gardenName;

    @ManyToOne(targetEntity = House.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "house_type_id", referencedColumnName = "house_id")
    private House houseType;

    @ManyToOne(targetEntity =GardenInfo.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "garden_type_id", referencedColumnName = "garden_name_id")
    private GardenInfo gardenType;

    @ManyToMany(targetEntity = Seeds.class, fetch = FetchType.EAGER)
    @JoinTable(name="seeds_to_plant",
            joinColumns = @JoinColumn(name="garden_id"),
            inverseJoinColumns = @JoinColumn(name="seed_id"))
    private List<Seeds> seedType;

    public Garden() {

        this.seedType = new ArrayList<>();
        this.gardenName = "";
    }

    public Garden(long gardenId, String gardenName, House houseType, GardenInfo gardenType, List<Seeds> seedType) {
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

    public House getHouseType() {
        return houseType;
    }

    public void setHouseType(House houseType) {
        this.houseType = houseType;
    }

    public GardenInfo getGardenType() {
        return gardenType;
    }

    public void setGardenType(GardenInfo gardenType) {
        this.gardenType = gardenType;
    }

    public List<Seeds> getSeedType() {
        return seedType;
    }

    public void setSeedType(List<Seeds> seedType) {
        this.seedType = seedType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garden garden = (Garden) o;
        return gardenId == garden.gardenId && Objects.equals(gardenName, garden.gardenName) && Objects.equals(houseType, garden.houseType) && Objects.equals(gardenType, garden.gardenType) && Objects.equals(seedType, garden.seedType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gardenId, gardenName, houseType, gardenType, seedType);
    }

    @Override
    public String toString() {
        return "Garden{" +
                "gardenId=" + gardenId +
                ", gardenName='" + gardenName + '\'' +
                ", houseType='" + houseType + '\'' +
                ", gardenType='" + gardenType + '\'' +
                ", seedType=" + seedType +
                '}';
    }
}
