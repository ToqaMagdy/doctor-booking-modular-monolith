package com.pinkspring.doctorbooking.availability;

import com.pinkspring.doctorbooking.availability.data.Slot;

import java.util.List;

/**
 * I expose here the methods needed by Appointment Booking Module
 */
public interface IslotService {

    List<SlotDTO> getAllDoctorAvailableSlots();
    List<SlotDTO> getAllUpComingSlots();
}
