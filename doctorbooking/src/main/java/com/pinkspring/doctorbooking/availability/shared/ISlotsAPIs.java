package com.pinkspring.doctorbooking.availability.shared;

import com.pinkspring.doctorbooking.availability.SlotDTO;

import java.util.List;

public interface ISlotsAPIs {

    List<SlotDTO> getAvailableSlots();

}
