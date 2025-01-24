package com.pinkspring.doctorbooking.commons.api.requests;

import jakarta.validation.constraints.Min;

public class PageRequest {

    @Min(0)
    private int page = 1;

    @Min(1)
    private int size = 10;

}
