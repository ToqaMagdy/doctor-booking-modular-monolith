package com.pinkspring.doctorbooking.management.internal.core.outputports;

import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;

import java.util.List;
import java.util.UUID;

public interface IAppointmentRepo {
    public List<Appointment> getAppointmentsBySlotIds(List<UUID> slotIds);

    public Appointment getAppointmentById(UUID appointmentId);

    public void save(Appointment appointment);
}
