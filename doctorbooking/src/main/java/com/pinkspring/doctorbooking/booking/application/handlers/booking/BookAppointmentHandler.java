package com.pinkspring.doctorbooking.booking.application.handlers.booking;

import com.pinkspring.doctorbooking.booking.infrastructure.gateways.AppointmentManagementGateway;
import com.pinkspring.doctorbooking.management.shared.CreateAppointmentDTO;
import org.springframework.stereotype.Service;

@Service
public class BookAppointmentHandler {

    private final AppointmentManagementGateway appointmentManagementGateway;

    public BookAppointmentHandler(AppointmentManagementGateway appointmentManagementGateway) {
        this.appointmentManagementGateway = appointmentManagementGateway;
    }

    public void handle(BookAppointment bookAppointment) {
        appointmentManagementGateway.bookAppointment(
                new CreateAppointmentDTO(
                        bookAppointment.patientId(),
                        bookAppointment.slotId(),
                        bookAppointment.patientName()));
    }
}
