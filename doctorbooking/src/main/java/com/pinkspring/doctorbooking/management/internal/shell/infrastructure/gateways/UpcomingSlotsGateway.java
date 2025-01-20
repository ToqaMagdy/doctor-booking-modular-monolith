package com.pinkspring.doctorbooking.management.internal.shell.infrastructure.gateways;

import com.pinkspring.doctorbooking.availability.shared.ISlotsAPIs;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.management.internal.shell.application.IUpcomingSlotsGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpcomingSlotsGateway implements IUpcomingSlotsGateway {
    private final ISlotsAPIs slotsAPIs;

    public UpcomingSlotsGateway(ISlotsAPIs slotsAPIs) {
        this.slotsAPIs = slotsAPIs;
    }

    @Override
    public List<SlotDTO> getAllUpcomingSlots() {
        return slotsAPIs.getAllUpComingSlots();
    }
}
