package com.pinkspring.doctorbooking.management.internal.shell.db;

import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class AppointmentEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID patientId;
    private UUID slotId;
    private String patientName;
    private LocalDate reservedAt;
    private String status;

    public Appointment toDomain(){
        return new Appointment(id, patientId, slotId, patientName, reservedAt);
    }

    public static AppointmentEntity fromDomain(Appointment appointment){
        AppointmentEntity entity = new AppointmentEntity();
        entity.id = appointment.getId();
        entity.patientId = appointment.getPatientId();
        entity.slotId = appointment.getSlotId();
        entity.patientName = appointment.getPatientName();
        entity.reservedAt = appointment.getReservedAt();
        return entity;
    }
}
