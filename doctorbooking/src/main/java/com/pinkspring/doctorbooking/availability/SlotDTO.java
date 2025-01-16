package com.pinkspring.doctorbooking.availability;

import java.util.UUID;

public record SlotDTO(UUID id,String doctorName,
                      Boolean isReserved,
                      String dateTime,
                      Double cost) {
    public SlotDTO(UUID id, String doctorName, Boolean isReserved, String dateTime, Double cost) {
        this.id = id;
        this.doctorName = doctorName;
        this.isReserved = isReserved;
        this.dateTime = dateTime;
        this.cost = cost;
    }
}
