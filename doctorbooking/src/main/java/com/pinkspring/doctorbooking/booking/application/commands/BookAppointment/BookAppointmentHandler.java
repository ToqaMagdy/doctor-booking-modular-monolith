package com.pinkspring.doctorbooking.booking.application.commands.BookAppointment;

import com.pinkspring.doctorbooking.booking.infrastructure.gateways.AppointmentManagementGateway;
import com.pinkspring.doctorbooking.management.shared.CreateAppointmentDTO;
import com.pinkspring.doctorbooking.management.shared.CreatedAppointmentDTO;
import org.springframework.stereotype.Service;

@Service
public class BookAppointmentHandler {

    private final AppointmentManagementGateway appointmentManagementGateway;

    public BookAppointmentHandler(AppointmentManagementGateway appointmentManagementGateway) {
        this.appointmentManagementGateway = appointmentManagementGateway;
    }

    public CreatedAppointmentDTO handle(BookAppointment bookAppointment) {
       return appointmentManagementGateway.bookAppointment(
                new CreateAppointmentDTO(
                        bookAppointment.patientId(),
                        bookAppointment.slotId(),
                        bookAppointment.patientName()));
    }
}
