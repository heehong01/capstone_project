package com.example.backend_capstone.jpa.enititymodels;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="seeds")
public class Seeds {
    public Long getSeedId() {
        return seedId;
    }

    public void setSeedId(Long seedId) {
        this.seedId = seedId;
    }

    @Id
   @Column(name = "seed_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long seedId;

   @Column(name="seed_name")
   private String seedName;

   @Column(name="seed_description")
   private String seedDescription;

    public Seeds(){

    }

    public Seeds(Long seedId, String seedName, String seedDescription) {
        this.seedId = seedId;
        this.seedName = seedName;
        this.seedDescription = seedDescription;
    }

    public String getSeedName() {
        return seedName;
    }

    public void setSeedName(String seedName) {
        this.seedName = seedName;
    }

    public String getSeedDescription() {
        return seedDescription;
    }

    public void setSeedDescription(String seedDescription) {
        this.seedDescription = seedDescription;
    }

    @Override
    public String toString() {
        return "Seeds{" +
                "seedName='" + seedName + '\'' +
                ", seedDescription='" + seedDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seeds seeds = (Seeds) o;
        return Objects.equals(seedName, seeds.seedName) && Objects.equals(seedDescription, seeds.seedDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seedName, seedDescription);
    }
}
