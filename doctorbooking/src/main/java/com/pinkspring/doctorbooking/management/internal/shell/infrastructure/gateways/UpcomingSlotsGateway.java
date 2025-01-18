package com.pinkspring.doctorbooking.management.internal.shell.infrastructure.gateways;

import com.pinkspring.doctorbooking.availability.IslotService;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.management.internal.shell.application.IUpcomingSlotsGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpcomingSlotsGateway implements IUpcomingSlotsGateway {
    private final IslotService slotsService;

    public UpcomingSlotsGateway(IslotService slotsService) {
        this.slotsService = slotsService;
    }

    @Override
    public List<SlotDTO> getAllUpcomingSlots() {
        return slotsService.getAllUpComingSlots();
    }
}
