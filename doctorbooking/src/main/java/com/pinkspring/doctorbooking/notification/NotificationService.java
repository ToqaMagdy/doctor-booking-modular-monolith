package com.pinkspring.doctorbooking.notification;

import com.pinkspring.doctorbooking.availability.data.Slot;
import com.pinkspring.doctorbooking.availability.domain.events.SlotCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @EventListener
    void on(SlotCreatedEvent event) {
        System.out.println("New Slot added by doctor: "+event.doctorName());
    }
}
