package com.pinkspring.doctorbooking.booking.application.contracts;

import com.pinkspring.doctorbooking.booking.application.models.AvailableSlot;

import java.util.List;

public interface IAvailabilityGateway {

    List<AvailableSlot> getAvailableSlots();

}
