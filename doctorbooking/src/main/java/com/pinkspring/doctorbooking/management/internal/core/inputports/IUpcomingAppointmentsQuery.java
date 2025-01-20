package com.pinkspring.doctorbooking.management.internal.core.inputports;

import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUpcomingAppointmentsQuery {

    public List<Appointment> getUpcomingDoctorsAppointments();
}
