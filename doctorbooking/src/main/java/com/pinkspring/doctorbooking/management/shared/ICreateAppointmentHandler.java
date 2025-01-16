package com.pinkspring.doctorbooking.management.shared;

import org.springframework.stereotype.Service;

@Service
public interface ICreateAppointmentHandler {
    //TODO: return AppointmentDTO instead of void
    void createAppointment(CreateAppointmentDTO appointmentDTO);
}
