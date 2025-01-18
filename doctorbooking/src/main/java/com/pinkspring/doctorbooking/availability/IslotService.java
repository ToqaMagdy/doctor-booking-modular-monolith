package com.pinkspring.doctorbooking.availability;

import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.availability.shared.SlotDTO;

import java.util.List;

/**
 * I expose here the methods needed by Appointment Booking Module
 */
public interface IslotService {

    List<SlotDTO> getAllDoctorAvailableSlots();
    List<SlotDTO> getAllUpComingSlots();
}
