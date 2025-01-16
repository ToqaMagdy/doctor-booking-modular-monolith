package com.pinkspring.doctorbooking.notification;

import com.pinkspring.doctorbooking.availability.data.Slot;
import com.pinkspring.doctorbooking.availability.domain.events.SlotCreatedEvent;
import com.pinkspring.doctorbooking.management.shared.AppointmentCreationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @EventListener
    void on(SlotCreatedEvent event) {
        System.out.println("New Slot added by doctor: "+event.doctorName());
    }

    @EventListener
    void on(AppointmentCreationEvent event) {
        System.out.println("New Appointment created for patient with ID " + event.patientId() +
                "and name: " + event.patientName() + " on " + event.date());
    }
}
