package com.pinkspring.doctorbooking.booking.api.controllers;

import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.booking.api.dto.GetAvailableSlotsRequest;
import com.pinkspring.doctorbooking.booking.application.queries.GetAvailableSlots.GetAvailableSlotsQuery;
import com.pinkspring.doctorbooking.booking.application.queries.GetAvailableSlots.IGetAvailableSlotsHandler;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAvailableSlotsController {

    private final IGetAvailableSlotsHandler getAvailableSlotsHandler;

    public GetAvailableSlotsController(IGetAvailableSlotsHandler getAvailableSlotsHandler) {
        this.getAvailableSlotsHandler = getAvailableSlotsHandler;
    }

    @GetMapping("/slots/available")
    public ResponseEntity<List<SlotDTO>> getAvailableSlots(@Valid GetAvailableSlotsRequest request) {
        GetAvailableSlotsQuery query = new GetAvailableSlotsQuery(
                request.getPage(),
                request.getSize()
        );
        return ResponseEntity.ok(getAvailableSlotsHandler.handle(query));
    }
}
