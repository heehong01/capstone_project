package com.example.backend_capstone.jpa.DTO;

import java.util.List;

public class SeedSelectionDTO {
    private List<Long> ids;

    public SeedSelectionDTO(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

}
