package com.pinkspring.doctorbooking.management.internal.shell.services;

import com.pinkspring.doctorbooking.management.shared.ICreateAppointmentHandler;
import org.springframework.stereotype.Service;

@Service
public class CreateAppointmentHandler implements ICreateAppointmentHandler {

    @Override
    public void createAppointment() {
        System.out.println("Creating appointment");
    }
}
