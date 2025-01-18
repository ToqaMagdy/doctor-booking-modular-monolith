package com.pinkspring.doctorbooking.booking.application.handlers.viewslots;

import com.pinkspring.doctorbooking.availability.SlotDTO;
import com.pinkspring.doctorbooking.booking.application.contracts.ISlotsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAvailableSlotsHandler {

    private final ISlotsGateway slotsGateway;

    public GetAvailableSlotsHandler(ISlotsGateway slotsGateway) {
        this.slotsGateway = slotsGateway;
    }

    public List<SlotDTO> handle(){
        return slotsGateway.getAvailableSlots();
    }
}
