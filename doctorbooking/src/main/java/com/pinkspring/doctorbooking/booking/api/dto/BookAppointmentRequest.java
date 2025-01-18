package com.pinkspring.doctorbooking.booking.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record BookAppointmentRequest(@NotNull UUID patientId, @NotBlank String patientName, @NotNull UUID slotId) {
}
