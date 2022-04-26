package com.example.backend_capstone.jpa.enititymodels;

import javax.persistence.*;

@Entity
@Table(name="garden_info")
public class GardenInfo {

    @Id
    @Column(name = "garden_name_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gardenNameId;

    @Column(name="garden_name")
    private String gardenName;

    @Column(name="garden_description")
    private String gardenDescription;

    public GardenInfo(){
    }
    public GardenInfo(Long gardenNameId, String gardenName, String gardenDescription) {
        this.gardenNameId = gardenNameId;
        this.gardenName = gardenName;
        this.gardenDescription = gardenDescription;
    }

    public Long getGardenNameId() {
        return gardenNameId;
    }

    public void setGardenNameId(Long gardenNameId) {
        this.gardenNameId = gardenNameId;
    }

    public String getGardenName() {
        return gardenName;
    }

    public void setGardenName(String gardenName) {
        this.gardenName = gardenName;
    }

    public String getGardenDescription() {
        return gardenDescription;
    }

    public void setGardenDescription(String gardenDescription) {
        this.gardenDescription = gardenDescription;
    }

}
