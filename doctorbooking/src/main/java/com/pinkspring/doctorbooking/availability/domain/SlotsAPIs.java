package com.pinkspring.doctorbooking.availability.domain;

import com.pinkspring.doctorbooking.availability.data.Slots;
import com.pinkspring.doctorbooking.availability.data.SlotsRepository;
import com.pinkspring.doctorbooking.availability.shared.ISlotsAPIs;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SlotsAPIs implements ISlotsAPIs {

    private final SlotsRepository slotsRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");

    public SlotsAPIs(SlotsRepository slotsRepository) {
        this.slotsRepository = slotsRepository;
    }

    @Override
    public List<SlotDTO> getAllAvailableSlots() {
        List<Slots> slots = slotsRepository.findDoctorAvailableSlots();
        return mapToSlotDto(slots);
    }

    @Override
    public List<SlotDTO> getAllUpComingSlots() {
        List<Slots> upcomingSlots = slotsRepository.findUpComingSlots();
        return mapToSlotDto(upcomingSlots);
    }

    private List<SlotDTO> mapToSlotDto(List<Slots> slots){
        return slots.stream().map(slot -> new SlotDTO(slot.getId(), slot.getDoctorName(),
                slot.getReserved(),
                slot.getTime().format(formatter),
                slot.getCost())).collect(Collectors.toList());
    }
}
