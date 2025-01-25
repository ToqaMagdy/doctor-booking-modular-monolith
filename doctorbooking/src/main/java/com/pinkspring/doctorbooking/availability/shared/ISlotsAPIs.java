package com.pinkspring.doctorbooking.availability.shared;

import java.util.List;

public interface ISlotsAPIs {

    List<SlotDTO> getAllAvailableSlots();
    List<SlotDTO> getAllUpComingSlots();

}
