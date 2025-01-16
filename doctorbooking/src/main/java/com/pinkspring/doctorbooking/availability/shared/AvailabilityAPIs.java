package com.pinkspring.doctorbooking.availability.shared;

import java.util.List;

public class AvailabilityAPIs implements IAvailabilityAPIs {

    @Override
    public List<AvailableSlotDTO> getAvailableSlots() {
        //calls service to get the available slots
        return List.of();
    }
}
