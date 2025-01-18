package com.pinkspring.doctorbooking.availability.domain;

import com.pinkspring.doctorbooking.availability.IslotService;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.availability.data.Slot;
import com.pinkspring.doctorbooking.availability.data.SlotRepository;
import com.pinkspring.doctorbooking.availability.domain.events.SlotCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class DoctorSlotsService implements IslotService {
    private final SlotRepository slotRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
    private final ApplicationEventPublisher eventPublisher;

    public DoctorSlotsService(SlotRepository slotRepository,
                              ApplicationEventPublisher eventPublisher) {
        this.slotRepository = slotRepository;
        this.eventPublisher = eventPublisher;
    }

    public void addNewSlot(SlotDTO slotDTO) {
        String doctorUUID="ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59";
        String doctorName = "Test doctor";
        Slot slot = new Slot();

        slot.setDoctorName(doctorName);
        slot.setTime(LocalDateTime.parse(slotDTO.dateTime(), formatter));
        slot.setDoctorId(UUID.fromString(doctorUUID));
        slot.setReserved(Boolean.FALSE);
        slot.setCost(slotDTO.cost());
        slot.setId(UUID.randomUUID());

        slotRepository.save(slot);
        // publish event after slot added
        SlotCreatedEvent slotCreatedEvent = new SlotCreatedEvent(doctorName);
        eventPublisher.publishEvent(slotCreatedEvent);
    }

    public List<SlotDTO> getAllSlots(){
        List<Slot> slots= slotRepository.findAll();
        return slots.stream().map(slot -> new SlotDTO(slot.getId(), slot.getDoctorId().toString(),
                slot.getReserved(),
                slot.getTime().format(formatter),
                slot.getCost())).collect(Collectors.toList());
    }

    @Override
    public List<SlotDTO> getAllDoctorAvailableSlots() {
        List<Slot> slots =slotRepository.findDoctorAvailableSlots();
        return mapToSlotDto(slots);
    }

    @Override
    public List<SlotDTO> getAllUpComingSlots() {
        List<Slot> upcomingSlots =slotRepository.findUpComingSlots();
        return mapToSlotDto(upcomingSlots);
    }

    private List<SlotDTO> mapToSlotDto(List<Slot> slots){
        return slots.stream().map(slot -> new SlotDTO(slot.getId(), slot.getDoctorId().toString(),
                slot.getReserved(),
                slot.getTime().format(formatter),
                slot.getCost())).collect(Collectors.toList());
    }
}
