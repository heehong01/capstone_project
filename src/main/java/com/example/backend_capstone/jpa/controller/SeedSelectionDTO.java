package com.example.backend_capstone.jpa.controller;

import java.util.List;

public class SeedSelectionDTO {
    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public SeedSelectionDTO(List<Long> ids) {
        this.ids = ids;
    }

    private List<Long> ids;


}
