package com.pinkspring.doctorbooking.availability.test.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinkspring.doctorbooking.availability.domain.DoctorSlotsService;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class SlotsAvailabilityControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorSlotsService doctorSlotsService;

    @Autowired
    private ObjectMapper objectMapper;

    private SlotDTO validSlotDTO;

    @BeforeEach
    void setUp() {
        validSlotDTO = new SlotDTO(UUID.fromString("ba17e6c5-b6a2-4762-b9ec-c6c4504e1c88"), "Test doctor", false, "16/01/2025 10:00 AM", 100.0);
    }

    @Test
    void testCreateSlot() throws Exception {
        // Arrange: Set up mock behavior for doctorSlotsService.addNewSlot
        doNothing().when(doctorSlotsService).addNewSlot(any());

        // Act: Perform the POST request to create a new slot
        mockMvc.perform(post("/api/doctors/slots")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(validSlotDTO)))
                .andExpect(status().isOk()) // Expect HTTP 200
                .andExpect(content().string("Slot added successfully!!"));

        // Assert: Verify that the service method was called once
        verify(doctorSlotsService, times(1)).addNewSlot(any());
    }

    @Test
    void testCreateSlotWithEmptyBody() throws Exception {
        // Act: Perform the POST request with an empty body
        SlotDTO slot = null;
        mockMvc.perform(post("/api/doctors/slots")
                        .contentType("application/json")
                        .content(String.valueOf(slot)))
                .andExpect(status().isBadRequest()); // Expect HTTP 400

        // Assert: Verify that the service method was not called
        verify(doctorSlotsService, never()).addNewSlot(any());
    }

    @Test
    void testGetAllSlots() throws Exception {
        // Arrange: Create mock data and set up mock behavior for doctorSlotsService.getAllSlots
        SlotDTO slotDTO = new SlotDTO(UUID.fromString("ba17e6c5-b6a2-4762-b9ec-c6c4504e1c88"), "Test doctor", false, "16/01/2025 10:00 AM", 100.0);
        List<SlotDTO> slots = List.of(slotDTO);
        when(doctorSlotsService.getAllSlots()).thenReturn(slots);

        // Act: Perform the GET request to retrieve all slots
        mockMvc.perform(get("/api/doctors/slots"))
                .andExpect(status().isOk()) // Expect HTTP 200
                .andExpect(jsonPath("$", hasSize(1))) // Check if there is 1 slot in the response
                .andExpect(jsonPath("$[0].id", is(slotDTO.id().toString()))) // Check the first slot's id
                .andExpect(jsonPath("$[0].doctorName", is(slotDTO.doctorName()))) // Check the first slot's doctor name
                .andExpect(jsonPath("$[0].dateTime", is(slotDTO.dateTime()))) // Check the first slot's dateTime
                .andExpect(jsonPath("$[0].cost", is(slotDTO.cost()))); // Check the first slot's cost

        // Assert: Verify that the service method was called once
        verify(doctorSlotsService, times(1)).getAllSlots();
    }
}

