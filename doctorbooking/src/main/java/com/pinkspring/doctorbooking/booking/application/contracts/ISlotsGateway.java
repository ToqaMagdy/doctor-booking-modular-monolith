package com.pinkspring.doctorbooking.booking.application.contracts;


import com.pinkspring.doctorbooking.availability.SlotDTO;

import java.util.List;

public interface ISlotsGateway {

    List<SlotDTO> getAvailableSlots();

}
