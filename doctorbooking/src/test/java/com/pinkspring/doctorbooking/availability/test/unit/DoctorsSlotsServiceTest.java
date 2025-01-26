package com.pinkspring.doctorbooking.availability.test.unit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.pinkspring.doctorbooking.availability.controllers.CreateSlotRequest;
import com.pinkspring.doctorbooking.availability.data.Slots;
import com.pinkspring.doctorbooking.availability.data.SlotsRepository;
import com.pinkspring.doctorbooking.availability.domain.DoctorSlotsService;
import com.pinkspring.doctorbooking.availability.domain.SlotsAPIs;
import com.pinkspring.doctorbooking.availability.domain.events.SlotCreatedEvent;
import com.pinkspring.doctorbooking.availability.shared.ISlotsAPIs;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DoctorsSlotsServiceTest {

    @Mock
    private SlotsRepository slotsRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    private DoctorSlotsService doctorSlotsService;

    private ISlotsAPIs slotsAPIs;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        doctorSlotsService = new DoctorSlotsService(slotsRepository, eventPublisher);
        slotsAPIs = new SlotsAPIs(slotsRepository);
    }

    @Test
    void testAddNewSlot() {
        // Arrange
        CreateSlotRequest request = new CreateSlotRequest("16/01/2025 10:00 AM", UUID.fromString("ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59"), "Test doctor", false, 100.0);

        // Act
        doctorSlotsService.addNewSlot(request);

        // Assert
        ArgumentCaptor<Slots> slotArgumentCaptor = ArgumentCaptor.forClass(Slots.class);
        verify(slotsRepository, times(1)).save(slotArgumentCaptor.capture());
        Slots savedSlots = slotArgumentCaptor.getValue();

        assertNotNull(savedSlots);
        assertEquals("Test doctor", savedSlots.getDoctorName());
        assertEquals(Boolean.FALSE, savedSlots.getReserved());
        assertEquals(100.0, savedSlots.getCost());
        assertEquals(UUID.fromString("ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59"), savedSlots.getDoctorId());
        assertEquals(LocalDateTime.parse("16/01/2025 10:00 AM", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")), savedSlots.getTime());

        verify(eventPublisher, times(1)).publishEvent(any(SlotCreatedEvent.class));
    }

    @Test
    void testGetAllSlots() {
        // Arrange
        Slots slots1 = new Slots();
        slots1.setId(UUID.randomUUID());
        slots1.setDoctorName("Test doctor");
        slots1.setTime(LocalDateTime.parse("16/01/2025 10:00 AM", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")));
        slots1.setReserved(false);
        slots1.setCost(100.0);
        slots1.setDoctorId(UUID.fromString("ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59"));


        List<Slots> slots = Collections.singletonList(slots1);
        when(slotsRepository.findAll()).thenReturn(slots);

        // Act
        List<SlotDTO> slotDTOs = doctorSlotsService.getAllSlots();

        // Assert
        assertNotNull(slotDTOs);
        assertEquals(1, slotDTOs.size());

        SlotDTO slotDTO = slotDTOs.get(0);
        assertEquals(slots1.getId(), slotDTO.id());
        assertEquals("Test doctor", slotDTO.doctorName());
        assertFalse(slotDTO.isReserved());
        assertEquals("16/01/2025 10:00 AM", slotDTO.dateTime());
        assertEquals(100.0, slotDTO.cost());
    }

    @Test
    void testGetAllDoctorAvailableSlots() {
        // Arrange
        Slots slots1 = new Slots();
        slots1.setId(UUID.randomUUID());
        slots1.setDoctorName("Test doctor");
        slots1.setTime(LocalDateTime.parse("16/01/2025 10:00 AM", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")));
        slots1.setReserved(false);
        slots1.setCost(100.0);
        slots1.setDoctorId(UUID.fromString("ba97e6c5-b6a2-4762-b9ec-c6c4504e1c59"));

        List<Slots> slots = Collections.singletonList(slots1);
        when(slotsRepository.findDoctorAvailableSlots()).thenReturn(slots);

        // Act
        List<SlotDTO> availableSlots = slotsAPIs.getAllAvailableSlots();

        // Assert
        assertNotNull(availableSlots);
        assertEquals(1, availableSlots.size());
        assertEquals("Test doctor", availableSlots.get(0).doctorName());
        assertFalse(availableSlots.get(0).isReserved());
    }

    @Test
    void testGetAllUpComingSlots() {
        // Arrange
        Slots slots1 = new Slots();
        slots1.setId(UUID.randomUUID());
        slots1.setDoctorName("Test doctor");
        slots1.setTime(LocalDateTime.parse("16/01/2025 10:00 AM", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")));
        slots1.setReserved(false);
        slots1.setCost(100.0);

        List<Slots> slots = Collections.singletonList(slots1);
        when(slotsRepository.findUpComingSlots()).thenReturn(slots);

        // Act
        List<SlotDTO> upcomingSlots = slotsAPIs.getAllUpComingSlots();

        // Assert
        assertNotNull(upcomingSlots);
        assertEquals(1, upcomingSlots.size());
        assertEquals("Test doctor", upcomingSlots.get(0).doctorName());
        assertFalse(upcomingSlots.get(0).isReserved());
    }
}

