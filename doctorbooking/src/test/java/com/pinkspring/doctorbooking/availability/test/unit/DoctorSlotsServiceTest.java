package com.pinkspring.doctorbooking.availability.test.unit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.pinkspring.doctorbooking.availability.data.Slot;
import com.pinkspring.doctorbooking.availability.data.SlotRepository;
import com.pinkspring.doctorbooking.availability.domain.DoctorSlotsService;
import com.pinkspring.doctorbooking.availability.domain.events.SlotCreatedEvent;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DoctorSlotsServiceTest {

    @Mock
    private SlotRepository slotRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    private DoctorSlotsService doctorSlotsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        doctorSlotsService = new DoctorSlotsService(slotRepository, eventPublisher);
    }

    @Test
    void testAddNewSlot() {
        // Arrange
        SlotDTO slotDTO = new SlotDTO(null, "ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59", false, "16/01/2025 10:00 AM", 100.0);

        // Act
        doctorSlotsService.addNewSlot(slotDTO);

        // Assert
        ArgumentCaptor<Slot> slotArgumentCaptor = ArgumentCaptor.forClass(Slot.class);
        verify(slotRepository, times(1)).save(slotArgumentCaptor.capture());
        Slot savedSlot = slotArgumentCaptor.getValue();

        assertNotNull(savedSlot);
        assertEquals("Test doctor", savedSlot.getDoctorName());
        assertEquals(Boolean.FALSE, savedSlot.getReserved());
        assertEquals(100.0, savedSlot.getCost());
        assertEquals(UUID.fromString("ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59"), savedSlot.getDoctorId());
        assertEquals(LocalDateTime.parse("16/01/2025 10:00 AM", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")), savedSlot.getTime());

        verify(eventPublisher, times(1)).publishEvent(any(SlotCreatedEvent.class));
    }

    @Test
    void testGetAllSlots() {
        // Arrange
        Slot slot1 = new Slot();
        slot1.setId(UUID.randomUUID());
        slot1.setDoctorName("Test doctor");
        slot1.setTime(LocalDateTime.parse("16/01/2025 10:00 AM", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")));
        slot1.setReserved(false);
        slot1.setCost(100.0);
        slot1.setDoctorId(UUID.fromString("ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59"));


        List<Slot> slots = Collections.singletonList(slot1);
        when(slotRepository.findAll()).thenReturn(slots);

        // Act
        List<SlotDTO> slotDTOs = doctorSlotsService.getAllSlots();

        // Assert
        assertNotNull(slotDTOs);
        assertEquals(1, slotDTOs.size());

        SlotDTO slotDTO = slotDTOs.get(0);
        assertEquals(slot1.getId(), slotDTO.id());
        assertEquals("Test doctor", slotDTO.doctorName());
        assertFalse(slotDTO.isReserved());
        assertEquals("16/01/2025 10:00 AM", slotDTO.dateTime());
        assertEquals(100.0, slotDTO.cost());
    }

    @Test
    void testGetAllDoctorAvailableSlots() {
        // Arrange
        Slot slot1 = new Slot();
        slot1.setId(UUID.randomUUID());
        slot1.setDoctorName("Test doctor");
        slot1.setTime(LocalDateTime.parse("16/01/2025 10:00 AM", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")));
        slot1.setReserved(false);
        slot1.setCost(100.0);
        slot1.setDoctorId(UUID.fromString("ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59"));

        List<Slot> slots = Collections.singletonList(slot1);
        when(slotRepository.findDoctorAvailableSlots()).thenReturn(slots);

        // Act
        List<SlotDTO> availableSlots = doctorSlotsService.getAllDoctorAvailableSlots();

        // Assert
        assertNotNull(availableSlots);
        assertEquals(1, availableSlots.size());
        assertEquals("Test doctor", availableSlots.get(0).doctorName());
        assertFalse(availableSlots.get(0).isReserved());
    }

    @Test
    void testGetAllUpComingSlots() {
        // Arrange
        Slot slot1 = new Slot();
        slot1.setId(UUID.randomUUID());
        slot1.setDoctorName("Test doctor");
        slot1.setTime(LocalDateTime.parse("16/01/2025 10:00 AM", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")));
        slot1.setReserved(false);
        slot1.setCost(100.0);

        List<Slot> slots = Collections.singletonList(slot1);
        when(slotRepository.findUpComingSlots()).thenReturn(slots);

        // Act
        List<SlotDTO> upcomingSlots = doctorSlotsService.getAllUpComingSlots();

        // Assert
        assertNotNull(upcomingSlots);
        assertEquals(1, upcomingSlots.size());
        assertEquals("Test doctor", upcomingSlots.get(0).doctorName());
        assertFalse(upcomingSlots.get(0).isReserved());
    }
}

