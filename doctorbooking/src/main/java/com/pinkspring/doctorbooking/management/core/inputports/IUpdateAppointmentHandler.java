package com.pinkspring.doctorbooking.management.core.inputports;

import com.pinkspring.doctorbooking.management.core.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IUpdateAppointmentHandler {
    public Appointment updateAppointmentStatus(UUID appointmentId, String status);
}
