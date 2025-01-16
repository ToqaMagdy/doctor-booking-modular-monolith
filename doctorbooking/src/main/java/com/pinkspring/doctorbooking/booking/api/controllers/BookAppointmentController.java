package com.pinkspring.doctorbooking.booking.api.controllers;

import com.pinkspring.doctorbooking.booking.api.dto.BookAppointmentRequest;
import com.pinkspring.doctorbooking.booking.application.handlers.booking.BookAppointment;
import com.pinkspring.doctorbooking.booking.application.handlers.booking.BookAppointmentHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAppointmentController {

    private final BookAppointmentHandler bookAppointmentHandler;

    public BookAppointmentController(BookAppointmentHandler bookAppointmentHandler) {
        this.bookAppointmentHandler = bookAppointmentHandler;
    }

    @PostMapping("/appointments")
    public void bookAppointment(BookAppointmentRequest request) {
        BookAppointment newAppointment = new BookAppointment(
                request.patientId(),
                request.patientName(),
                request.slotId());
        //return bookAppointmentHandler.handle(newAppointment);
    }

}
