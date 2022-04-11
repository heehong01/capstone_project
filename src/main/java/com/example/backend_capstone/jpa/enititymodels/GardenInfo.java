package com.example.backend_capstone.jpa.enititymodels;

import javax.persistence.*;

@Entity
@Table(name="garden_info")
public class GardenInfo {
    @Id
    @Column(name="garden_name", nullable=false)
    private String gardenName;

    @Column(name="garden_description", nullable = false)
    private String gardenDescription;

    public GardenInfo(){
    }
    public GardenInfo( String gardenName, String gardenDescription) {
        this.gardenName = gardenName;
        this.gardenDescription = gardenDescription;
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
