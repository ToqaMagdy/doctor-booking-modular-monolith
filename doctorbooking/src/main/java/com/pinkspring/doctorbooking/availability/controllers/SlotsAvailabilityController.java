package com.pinkspring.doctorbooking.availability.controllers;

import com.pinkspring.doctorbooking.availability.SlotDTO;
import com.pinkspring.doctorbooking.availability.domain.DoctorSlotsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
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
        return ResponseEntity.badRequest().body("Empty body !");
    }

    @GetMapping(path ="/slots",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SlotDTO>> getAllSlots(){
        return ResponseEntity.ok(doctorSlotsService.getAllSlots());
    }

}
