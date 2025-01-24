package com.pinkspring.doctorbooking.booking.infrastructure.queries.handlers;

import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.booking.application.contracts.ISlotsGateway;
import com.pinkspring.doctorbooking.booking.application.queries.GetAvailableSlots.GetAvailableSlotsQuery;
import com.pinkspring.doctorbooking.booking.application.queries.GetAvailableSlots.IGetAvailableSlotsHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAvailableSlotsHandler implements IGetAvailableSlotsHandler {

    private final ISlotsGateway slotsGateway;

    public GetAvailableSlotsHandler(ISlotsGateway slotsGateway) {
        this.slotsGateway = slotsGateway;
    }

    @Override
    public List<SlotDTO> handle(GetAvailableSlotsQuery query) {
        //TODO: add pagination in gateway
        return slotsGateway.getAllAvailableSlots();
    }
}
