package com.pinkspring.doctorbooking.booking.application.queries.GetAvailableSlots;

import com.pinkspring.doctorbooking.commons.api.queries.IQuery;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class GetAvailableSlotsQuery implements IQuery {

    @Min(value = 0, message = "Min page number is 0")
    private int page = 1;

    @Min(value = 1, message = "Max page size is 50")
    @Max(value = 50, message = "Max page size is 50")
    private int size = 10;

    public GetAvailableSlotsQuery(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
