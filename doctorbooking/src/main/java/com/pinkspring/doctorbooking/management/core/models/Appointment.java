package com.pinkspring.doctorbooking.management.core.models;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class Appointment {
    private UUID id;
    private UUID patientId;
    private UUID slotId;
    private String patientName;
    private LocalDate reservedAt;
}
