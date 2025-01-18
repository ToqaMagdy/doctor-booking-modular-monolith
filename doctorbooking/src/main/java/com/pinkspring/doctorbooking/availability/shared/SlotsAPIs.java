package com.pinkspring.doctorbooking.availability.shared;

import com.pinkspring.doctorbooking.availability.SlotDTO;
import com.pinkspring.doctorbooking.availability.data.SlotRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SlotsAPIs implements ISlotsAPIs {

    private final SlotRepository slotRepository;

    public SlotsAPIs(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public List<SlotDTO> getAvailableSlots() {
       //TODO: get available slots from repository and map it to SlotDTO
        return new ArrayList<>();
    }
}
