package com.pinkspring.doctorbooking.availability.domain;

import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.availability.data.Slots;
import com.pinkspring.doctorbooking.availability.data.SlotsRepository;
import com.pinkspring.doctorbooking.availability.domain.events.SlotCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class DoctorSlotsService {
    private final SlotsRepository slotsRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
    private final ApplicationEventPublisher eventPublisher;

    public DoctorSlotsService(SlotsRepository slotsRepository,
                              ApplicationEventPublisher eventPublisher) {
        this.slotsRepository = slotsRepository;
        this.eventPublisher = eventPublisher;
    }

    public void addNewSlot(SlotDTO slotDTO) {
        String doctorUUID="ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59";
        String doctorName = "Test doctor";
        Slots slots = new Slots();

        slots.setDoctorName(doctorName);
        slots.setTime(LocalDateTime.parse(slotDTO.dateTime(), formatter));
        slots.setDoctorId(UUID.fromString(doctorUUID));
        slots.setReserved(Boolean.FALSE);
        slots.setCost(slotDTO.cost());
        slots.setId(UUID.randomUUID());

        slotsRepository.save(slots);
        // publish event after slot added
        SlotCreatedEvent slotCreatedEvent = new SlotCreatedEvent(doctorName);
        eventPublisher.publishEvent(slotCreatedEvent);
    }

    public List<SlotDTO> getAllSlots(){
        List<Slots> slots= slotsRepository.findAll();
        return slots.stream().map(slot -> new SlotDTO(slot.getId(), slot.getDoctorName(),
                slot.getReserved(),
                slot.getTime().format(formatter),
                slot.getCost())).collect(Collectors.toList());
    }

}
