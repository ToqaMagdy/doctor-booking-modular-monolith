package com.pinkspring.doctorbooking.booking.infrastructure.gateways;

import com.pinkspring.doctorbooking.booking.application.contracts.IAppointmentManagementGateway;
import com.pinkspring.doctorbooking.management.shared.CreateAppointmentDTO;
import com.pinkspring.doctorbooking.management.shared.CreatedAppointmentDTO;
import com.pinkspring.doctorbooking.management.shared.ICreateAppointmentHandler;
import org.springframework.stereotype.Component;

@Component
public class AppointmentManagementGateway implements IAppointmentManagementGateway {

    private final ICreateAppointmentHandler createAppointmentHandler;

    public AppointmentManagementGateway(ICreateAppointmentHandler createAppointmentHandler) {
        this.createAppointmentHandler = createAppointmentHandler;
    }

    @Override
    public CreatedAppointmentDTO bookAppointment(CreateAppointmentDTO createAppointmentDTO) {
        return createAppointmentHandler.createAppointment(createAppointmentDTO);
    }
}
