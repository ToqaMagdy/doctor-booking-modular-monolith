package com.pinkspring.doctorbooking.booking.api.controllers;

import com.pinkspring.doctorbooking.booking.application.handlers.slots.GetAvailableSlotsHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAvailableSlotsController {

    private final GetAvailableSlotsHandler getAvailableSlotsHandler;

    public GetAvailableSlotsController(GetAvailableSlotsHandler getAvailableSlotsHandler) {
        this.getAvailableSlotsHandler = getAvailableSlotsHandler;
    }

    @GetMapping("/slots")
    public ResponseEntity<?> getAvailableSlots() {
        return (ResponseEntity<?>) getAvailableSlotsHandler.handle();
    }
}
