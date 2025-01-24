package com.pinkspring.doctorbooking.commons.api.requests;

import jakarta.validation.constraints.Min;
import lombok.Getter;

public class PageRequest {

    @Min(0)
    private int page = 1;

    @Min(1)
    private int size = 10;

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
