package com.pinkspring.doctorbooking.availability.controllers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateSlotRequest(@NotNull String time, @NotBlank UUID doctorId, @NotBlank String doctorName, @NotNull boolean isReserved, @NotNull Double cost){
}
