package com.example.backend_capstone.jpa.enititymodels;

import javax.persistence.*;

@Entity
@Table(name="House")
public class House {
    @Id
    @Column(name = "house_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long houseId;

    @Column(name="house_name")
    private String houseName;

    @Column(name="house_description")
    private String houseDescription;

    public House(){

    }

    public House(Long houseId, String houseName, String houseDescription) {
        this.houseId = houseId;
        this.houseName = houseName;
        this.houseDescription = houseDescription;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }
}
