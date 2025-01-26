package com.pinkspring.doctorbooking.management.shared;

import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;
import org.springframework.stereotype.Service;

@Service
public interface ICreateAppointmentHandler {
    CreatedAppointmentDTO createAppointment(CreateAppointmentDTO appointmentDTO);
}
