package com.pinkspring.doctorbooking.availability.shared;

import java.util.UUID;

public record SlotDTO(UUID id,String doctorName,
                      Boolean isReserved,
                      String dateTime,
                      Double cost) {
}
