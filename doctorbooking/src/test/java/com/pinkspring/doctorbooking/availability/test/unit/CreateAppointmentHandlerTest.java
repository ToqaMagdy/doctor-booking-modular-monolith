package com.pinkspring.doctorbooking.availability.test.unit;

import com.pinkspring.doctorbooking.management.internal.core.outputports.IAppointmentRepo;
import com.pinkspring.doctorbooking.management.internal.core.services.CreateAppointmentHandler;
import com.pinkspring.doctorbooking.management.shared.AppointmentCreationEvent;
import com.pinkspring.doctorbooking.management.shared.CreateAppointmentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateAppointmentHandlerTest {

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Mock
    private IAppointmentRepo appointmentRepo;

    private CreateAppointmentHandler handler;

    @BeforeEach
    void setUp() {
        handler = new CreateAppointmentHandler(eventPublisher, appointmentRepo);
    }

    @Test
    void createAppointment_shouldSaveAppointmentAndPublishEvent() {
        // Arrange
        CreateAppointmentDTO dto = new CreateAppointmentDTO(UUID.randomUUID(), UUID.randomUUID(), "John Doe");

        when(appointmentRepo.save(any())).thenReturn(dto.toDomain());

        // Act
        handler.createAppointment(dto);

        // Assert
        verify(appointmentRepo).save(any());
        verify(eventPublisher).publishEvent(any(AppointmentCreationEvent.class));
    }

    @Test
    void createAppointment_shouldPublishCorrectEvent() {
        UUID patientId = UUID.randomUUID();
        // Arrange
        CreateAppointmentDTO dto = new CreateAppointmentDTO(patientId, UUID.randomUUID(), "John Doe");

        when(appointmentRepo.save(any())).thenReturn(dto.toDomain());
        ArgumentCaptor<AppointmentCreationEvent> eventCaptor = ArgumentCaptor.forClass(AppointmentCreationEvent.class);

        // Act
        handler.createAppointment(dto);

        // Assert
        verify(eventPublisher).publishEvent(eventCaptor.capture());
        AppointmentCreationEvent capturedEvent = eventCaptor.getValue();


        assertEquals(patientId, capturedEvent.patientId());
        assertEquals("John Doe", capturedEvent.patientName());
        assertEquals(LocalDate.now().toString(), capturedEvent.date());
    }
}
