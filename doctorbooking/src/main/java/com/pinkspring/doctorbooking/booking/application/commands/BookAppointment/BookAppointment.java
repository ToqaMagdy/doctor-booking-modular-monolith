package com.pinkspring.doctorbooking.booking.application.commands.BookAppointment;

import java.util.UUID;

public record BookAppointment(UUID patientId, String patientName, UUID slotId) {
}
