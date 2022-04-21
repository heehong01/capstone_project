package com.example.backend_capstone.jpa.DTO;

public class GardenInfoSelectionDTO {
    private Long gardenInfoId;

    public GardenInfoSelectionDTO(Long gardenInfoId) {
        this.gardenInfoId = gardenInfoId;
    }

    public Long getGardenInfoId() {
        return gardenInfoId;
    }

    public void setGardenInfoId(Long gardenInfoId) {
        this.gardenInfoId = gardenInfoId;
    }


}
