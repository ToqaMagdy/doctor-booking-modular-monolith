package com.pinkspring.doctorbooking.management.core.models;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
public class Appointment {
    private UUID id;
    private UUID patientId;
    private UUID slotId;
    private String patientName;
    private LocalDate reservedAt;
    private String status;

    public Appointment(UUID id, UUID patientId, UUID slotId, String patientName, LocalDate reservedAt) {
        this.id = id;
        this.patientId = patientId;
        this.slotId = slotId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDate reservedAt) {
        this.reservedAt = reservedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
