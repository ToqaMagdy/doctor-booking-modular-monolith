package com.pinkspring.doctorbooking.management.shell.db;

import java.time.LocalDate;
import java.util.UUID;


public class AppointmentEntity {
    private UUID id;
    private UUID patientId;
    private UUID slotId;
    private String patientName;
    private LocalDate reservedAt;
}
