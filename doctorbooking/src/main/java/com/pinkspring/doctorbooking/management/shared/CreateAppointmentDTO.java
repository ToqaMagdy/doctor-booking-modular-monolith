package com.pinkspring.doctorbooking.management.shared;

import java.util.UUID;

public record CreateAppointmentDTO(UUID patientId, UUID slotId, String patientName){}