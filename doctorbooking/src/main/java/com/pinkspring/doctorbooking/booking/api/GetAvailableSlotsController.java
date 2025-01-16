package com.pinkspring.doctorbooking.booking.api;

import com.pinkspring.doctorbooking.booking.application.handlers.getslots.GetAvailableSlotsHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetAvailableSlotsController {

    private final GetAvailableSlotsHandler getAvailableSlotsHandler;

    @GetMapping("/slots")
    public ResponseEntity<?> getAvailableSlots() {
        return (ResponseEntity<?>) getAvailableSlotsHandler.handle();
    }
}
