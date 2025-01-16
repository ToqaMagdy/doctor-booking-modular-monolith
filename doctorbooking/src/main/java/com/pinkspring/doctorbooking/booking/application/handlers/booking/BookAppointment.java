package com.pinkspring.doctorbooking.booking.application.handlers.booking;

import java.util.UUID;

public record BookAppointment(UUID patientId, String patientName, UUID slotId) {
}
