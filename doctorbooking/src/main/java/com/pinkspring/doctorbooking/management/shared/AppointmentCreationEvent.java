package com.pinkspring.doctorbooking.management.shared;

public record AppointmentCreationEvent (String patientId, String doctorId, String date) {
}
