package com.pinkspring.doctorbooking.booking.application.contracts;

import com.pinkspring.doctorbooking.management.shared.CreateAppointmentDTO;

public interface IAppointmentManagementGateway {

    void bookAppointment(CreateAppointmentDTO createAppointmentDTO);

}
