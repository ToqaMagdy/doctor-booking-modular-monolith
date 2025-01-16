package com.pinkspring.doctorbooking.booking.infrastructure.gateways;

import com.pinkspring.doctorbooking.availability.shared.IAvailabilityAPIs;
import com.pinkspring.doctorbooking.booking.application.contracts.IAvailabilityGateway;
import com.pinkspring.doctorbooking.booking.application.models.AvailableSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AvailabilityGateway implements IAvailabilityGateway {

    private final IAvailabilityAPIs availabilityAPIs;


    @Override
    public List<AvailableSlot> getAvailableSlots() {
        return availabilityAPIs.getAvailableSlots().stream()
                .map(slot -> new AvailableSlot(
                    slot.id(),
                    slot.doctorName(),
                    slot.isReserved(),
                    slot.dateTime(),
                    slot.cost())).toList();
    }
}
