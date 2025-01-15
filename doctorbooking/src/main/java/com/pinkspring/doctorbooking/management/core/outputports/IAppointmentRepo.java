package com.pinkspring.doctorbooking.management.core.outputports;

import com.pinkspring.doctorbooking.management.core.models.Appointment;
import com.pinkspring.doctorbooking.management.shell.db.AppointmentEntity;

import java.util.List;
import java.util.UUID;

public interface IAppointmentRepo {
    public List<Appointment> getAllDoctorsAppointments(UUID doctorId);

    public Appointment getAppointmentById(UUID appointmentId);
    public void save(Appointment appointment);
}
