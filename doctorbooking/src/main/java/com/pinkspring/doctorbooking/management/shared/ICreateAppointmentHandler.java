package com.pinkspring.doctorbooking.management.shared;

import org.springframework.stereotype.Service;

@Service
public interface ICreateAppointmentHandler {
    public void createAppointment(CreateAppointmentDTO appointmentDTO);
}
