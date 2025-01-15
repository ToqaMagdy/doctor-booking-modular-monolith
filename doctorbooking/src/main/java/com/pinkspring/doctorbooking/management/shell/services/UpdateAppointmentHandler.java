package com.pinkspring.doctorbooking.management.shell.services;

import com.pinkspring.doctorbooking.management.core.inputports.IUpdateAppointmentHandler;
import com.pinkspring.doctorbooking.management.core.models.Appointment;
import com.pinkspring.doctorbooking.management.core.outputports.IAppointmentRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UpdateAppointmentHandler implements IUpdateAppointmentHandler {

    private final IAppointmentRepo appointmentRepo;

    public UpdateAppointmentHandler(IAppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public Appointment updateAppointmentStatus(UUID appointmentId, String status) {

        Appointment appointment = appointmentRepo.getAppointmentById(appointmentId);
        appointment.setStatus(status);
        appointmentRepo.save(appointment);
        return appointment;
    }
}
