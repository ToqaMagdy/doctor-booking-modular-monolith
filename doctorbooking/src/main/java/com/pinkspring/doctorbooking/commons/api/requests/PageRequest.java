package com.pinkspring.doctorbooking.commons.api.requests;

import jakarta.validation.constraints.Min;

public class PageRequest {

    @Min(1)
    private int page = 1;

    @Min(1)
    private int size = 10;

    @Min(1)
    public int getSize() {
        return size;
    }

    public void setSize(@Min(1) int size) {
        this.size = size;
    }

    @Min(1)
    public int getPage() {
        return page;
    }

    public void setPage(@Min(1) int page) {
        this.page = page;
    }
}
