package com.pinkspring.doctorbooking.availability.domain;

import com.pinkspring.doctorbooking.availability.data.Slot;
import com.pinkspring.doctorbooking.availability.data.SlotRepository;
import com.pinkspring.doctorbooking.availability.shared.ISlotsAPIs;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SlotsAPIs implements ISlotsAPIs {

    private final SlotRepository slotRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");

    public SlotsAPIs(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public List<SlotDTO> getAllAvailableSlots() {
        List<Slot> slots = slotRepository.findDoctorAvailableSlots();
        return mapToSlotDto(slots);
    }

    @Override
    public List<SlotDTO> getAllUpComingSlots() {
        List<Slot> upcomingSlots = slotRepository.findUpComingSlots();
        return mapToSlotDto(upcomingSlots);
    }

    private List<SlotDTO> mapToSlotDto(List<Slot> slots){
        return slots.stream().map(slot -> new SlotDTO(slot.getId(), slot.getDoctorName(),
                slot.getReserved(),
                slot.getTime().format(formatter),
                slot.getCost())).collect(Collectors.toList());
    }
}
