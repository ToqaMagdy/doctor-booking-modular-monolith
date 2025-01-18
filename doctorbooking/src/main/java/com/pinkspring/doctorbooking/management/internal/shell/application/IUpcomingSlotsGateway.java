package com.pinkspring.doctorbooking.management.internal.shell.application;

import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface IUpcomingSlotsGateway {
    List<SlotDTO> getAllUpcomingSlots();
}
