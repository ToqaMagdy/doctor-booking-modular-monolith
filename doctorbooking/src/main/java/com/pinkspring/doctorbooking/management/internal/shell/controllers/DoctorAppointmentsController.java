package com.pinkspring.doctorbooking.management.internal.shell.controllers;

import com.pinkspring.doctorbooking.management.internal.core.inputports.IUpcomingAppointmentsQuery;
import com.pinkspring.doctorbooking.management.internal.core.inputports.IUpdateAppointmentHandler;
import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("appointments")
public class DoctorAppointmentsController {

    private final IUpcomingAppointmentsQuery upcomingAppointmentsQuery;

    private final IUpdateAppointmentHandler updateAppointmentHandler;

    public DoctorAppointmentsController(IUpcomingAppointmentsQuery upcomingAppointmentsQuery, IUpdateAppointmentHandler updateAppointmentHandler) {
        this.upcomingAppointmentsQuery = upcomingAppointmentsQuery;
        this.updateAppointmentHandler = updateAppointmentHandler;
    }

    @GetMapping
    public List<Appointment> getAllDoctorsAppointments() {
        return upcomingAppointmentsQuery.getUpcomingDoctorsAppointments();
    }

    @PutMapping("/{appointmentId}/status")
    public ResponseEntity<Appointment> updateAppointmentStatus(
            @PathVariable("appointmentId") String appointmentId,
            @RequestParam("status") String status) {

        UUID appointmentUuid = UUID.fromString(appointmentId);

        return ResponseEntity.ok(updateAppointmentHandler.updateAppointmentStatus(appointmentUuid, status));
    }


}
