package com.pinkspring.doctorbooking.management.shared;

import java.time.LocalDate;
import java.util.UUID;

public record CreateAppointmentDTO(UUID patientId, UUID slotId, String patientName){}