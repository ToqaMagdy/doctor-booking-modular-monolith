package com.pinkspring.doctorbooking.booking.application.queries.GetAvailableSlots;

import com.pinkspring.doctorbooking.availability.shared.SlotDTO;

import java.util.List;

public interface IGetAvailableSlotsHandler {
    List<SlotDTO> handle(GetAvailableSlotsQuery query);
}
