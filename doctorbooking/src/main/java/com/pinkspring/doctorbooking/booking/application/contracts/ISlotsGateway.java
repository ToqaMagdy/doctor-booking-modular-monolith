package com.pinkspring.doctorbooking.booking.application.contracts;


import com.pinkspring.doctorbooking.availability.shared.SlotDTO;

import java.util.List;

public interface ISlotsGateway {

    List<SlotDTO> getAvailableSlots();

}
