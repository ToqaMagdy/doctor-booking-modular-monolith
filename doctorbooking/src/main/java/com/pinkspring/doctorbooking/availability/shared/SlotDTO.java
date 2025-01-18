package com.pinkspring.doctorbooking.availability;

import java.util.UUID;

public record SlotDTO(UUID id,String doctorName,
                      Boolean isReserved,
                      String dateTime,
                      Double cost) {
}
