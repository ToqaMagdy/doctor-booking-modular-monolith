package com.pinkspring.doctorbooking.booking.infrastructure.gateways;

import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.booking.application.contracts.ISlotsGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SlotsGateway implements ISlotsGateway {

    private final com.pinkspring.doctorbooking.availability.shared.ISlotsAPIs slotsAPIs;

    public SlotsGateway(com.pinkspring.doctorbooking.availability.shared.ISlotsAPIs slotsAPIs) {
        this.slotsAPIs = slotsAPIs;
    }

    @Override
    public List<SlotDTO> getAvailableSlots() {
        return slotsAPIs.getAvailableSlots();
    }
}
