package com.pinkspring.doctorbooking.availability.controllers;

import com.pinkspring.doctorbooking.availability.data.Slots;
import com.pinkspring.doctorbooking.availability.domain.DoctorSlotsService;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import java.util.List;

import static com.pinkspring.doctorbooking.commons.api.constants.Urls.DOCTORS_PREFIX;

@RestController
@RequestMapping(DOCTORS_PREFIX)
public class SlotsAvailabilityController {

    private final DoctorSlotsService doctorSlotsService;

    public SlotsAvailabilityController(final DoctorSlotsService doctorSlotsService) {
        this.doctorSlotsService = doctorSlotsService;
    }


    @PostMapping(path ="/slots",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createSlot(@RequestBody CreateSlotRequest request){
        if(request != null) {
            doctorSlotsService.addNewSlot(request);
            return ResponseEntity.ok("Slot added successfully!!");
        }
        return ResponseEntity.badRequest().body("Empty body !");
    }

    @GetMapping(path ="/slots",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SlotDTO>> getAllSlots(){
        return ResponseEntity.ok(doctorSlotsService.getAllSlots());
    }

}
