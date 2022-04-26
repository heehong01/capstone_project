package com.example.backend_capstone.jpa.DTO;

public class HouseSelectionDTO {
    private Long houseId;

    public HouseSelectionDTO(Long houseId) {
        System.out.println("COnstructor" + houseId);
        this.houseId = houseId;
    }

    public Long getHouseId() {
        System.out.println("Getter" +houseId);
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

}
