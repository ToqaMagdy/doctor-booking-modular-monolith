package com.pinkspring.doctorbooking.availability.controllers;

import com.pinkspring.doctorbooking.availability.SlotDTO;
import com.pinkspring.doctorbooking.availability.domain.DoctorSlotsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/doctors")
public class SlotsAvailabilityController {

    private final DoctorSlotsService doctorSlotsService;

    public SlotsAvailabilityController(final DoctorSlotsService doctorSlotsService) {
        this.doctorSlotsService = doctorSlotsService;
    }


    @PostMapping(path ="/slots",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createSlot(@RequestBody SlotDTO slot){
        if(slot != null) {

            doctorSlotsService.addNewSlot(slot);
            return ResponseEntity.ok("Slot added successfully!!");
        }
        return ResponseEntity.badRequest().build();
    }

}
