package com.pinkspring.doctorbooking.management.shared;

import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;

import java.time.LocalDate;
import java.util.UUID;

public record CreateAppointmentDTO(UUID patientId, UUID slotId, String patientName){
    public Appointment toDomain(){
        return new Appointment(UUID.randomUUID(), patientId(), slotId(), patientName(), LocalDate.now(), "RESERVED");
    }
}