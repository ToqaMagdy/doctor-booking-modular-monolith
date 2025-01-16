package com.pinkspring.doctorbooking.management.internal.shell.controllers;

import com.pinkspring.doctorbooking.management.internal.core.inputports.IUpdateAppointmentHandler;
import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;
import com.pinkspring.doctorbooking.management.internal.core.outputports.IAppointmentRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("appointments")
public class DoctorAppointmentsController {

    private final IAppointmentRepo appointmentRepo;

    private final IUpdateAppointmentHandler updateAppointmentHandler;

    public DoctorAppointmentsController(IAppointmentRepo appointmentRepo, IUpdateAppointmentHandler updateAppointmentHandler) {
        this.appointmentRepo = appointmentRepo;
        this.updateAppointmentHandler = updateAppointmentHandler;
    }

    @GetMapping
    public List<Appointment> getAllDoctorsAppointments() {
        return appointmentRepo.getAllDoctorsAppointments();
    }

    @PutMapping("/{appointmentId}/status")
    public ResponseEntity<Appointment> updateAppointmentStatus(
            @PathVariable("appointmentId") String appointmentId,
            @RequestParam("status") String status) {

        UUID appointmentUuid = UUID.fromString(appointmentId);

        return ResponseEntity.ok(updateAppointmentHandler.updateAppointmentStatus(appointmentUuid, status));
    }


}
