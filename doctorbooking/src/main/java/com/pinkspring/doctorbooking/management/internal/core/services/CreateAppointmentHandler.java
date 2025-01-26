package com.pinkspring.doctorbooking.management.internal.core.services;

import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;
import com.pinkspring.doctorbooking.management.internal.core.outputports.IAppointmentRepo;
import com.pinkspring.doctorbooking.management.shared.AppointmentCreationEvent;
import com.pinkspring.doctorbooking.management.shared.CreateAppointmentDTO;
import com.pinkspring.doctorbooking.management.shared.CreatedAppointmentDTO;
import com.pinkspring.doctorbooking.management.shared.ICreateAppointmentHandler;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreateAppointmentHandler implements ICreateAppointmentHandler {
    private final ApplicationEventPublisher eventPublisher;
    private final IAppointmentRepo appointmentRepo;

    public CreateAppointmentHandler(ApplicationEventPublisher eventPublisher, IAppointmentRepo appointmentRepo) {
        this.eventPublisher = eventPublisher;
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public CreatedAppointmentDTO createAppointment(CreateAppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentRepo.save(appointmentDTO.toDomain());
        AppointmentCreationEvent event = new AppointmentCreationEvent(appointmentDTO.patientId(),
                appointmentDTO.patientName(), LocalDate.now().toString());
        eventPublisher.publishEvent(event);
        return new CreatedAppointmentDTO(appointment.getId(), appointment.getPatientId(), appointment.getSlotId(),
                appointment.getPatientName(), appointment.getStatus());
    }
}
