package com.pinkspring.doctorbooking.management.shared;

import java.util.UUID;

public record AppointmentCreationEvent (UUID patientId, String patientName, String date) {
}
