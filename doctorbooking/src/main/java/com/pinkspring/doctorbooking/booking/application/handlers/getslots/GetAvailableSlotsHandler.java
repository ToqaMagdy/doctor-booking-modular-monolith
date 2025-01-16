package com.pinkspring.doctorbooking.booking.application.handlers.getslots;

import com.pinkspring.doctorbooking.booking.application.contracts.IAvailabilityGateway;
import com.pinkspring.doctorbooking.booking.application.models.AvailableSlot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAvailableSlotsHandler {

    private final IAvailabilityGateway availabilityGateway;

    public List<AvailableSlot> handle(){
        return availabilityGateway.getAvailableSlots();
    }
}
