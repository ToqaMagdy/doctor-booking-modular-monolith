package com.pinkspring.doctorbooking.management.shared;

import java.util.UUID;

public record CreatedAppointmentDTO(UUID appointmentId, UUID patientId, UUID slotId, String patientName, String status) {
}
