package com.example.backend_capstone.jpa.enititymodels;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="seeds")
public class Seeds {
   @Id
   @Column(name="seed_name", nullable = false)
   private String seedName;

   @Type(type = Text)
   @Column(name="seed_description", nullable = false, )
   private String seedDescription;

    public Seeds(){

    }

    public Seeds( String seedName, String seedDescription) {
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
}
