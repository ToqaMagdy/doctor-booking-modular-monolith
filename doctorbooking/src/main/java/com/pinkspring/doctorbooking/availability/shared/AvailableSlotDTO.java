package com.pinkspring.doctorbooking.availability.shared;

import java.util.UUID;

public record AvailableSlotDTO(UUID id,
                            String doctorName,
                            Boolean isReserved,
                            String dateTime,
                            Double cost) {
}
