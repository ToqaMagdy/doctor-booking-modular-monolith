package com.pinkspring.doctorbooking.booking.application.models;

import java.util.UUID;

public record AvailableSlot(UUID id,
                            String doctorName,
                            Boolean isReserved,
                            String dateTime,
                            Double cost) {
}
