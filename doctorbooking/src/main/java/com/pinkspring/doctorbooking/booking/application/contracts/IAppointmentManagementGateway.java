package com.pinkspring.doctorbooking.booking.application.contracts;

import com.pinkspring.doctorbooking.management.shared.CreateAppointmentDTO;
import com.pinkspring.doctorbooking.management.shared.CreatedAppointmentDTO;

public interface IAppointmentManagementGateway {

    CreatedAppointmentDTO bookAppointment(CreateAppointmentDTO createAppointmentDTO);

}
