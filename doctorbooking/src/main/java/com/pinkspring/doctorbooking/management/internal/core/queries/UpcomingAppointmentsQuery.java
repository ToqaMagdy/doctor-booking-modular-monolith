package com.pinkspring.doctorbooking.management.internal.core.queries;

import com.pinkspring.doctorbooking.availability.shared.SlotDTO;
import com.pinkspring.doctorbooking.management.internal.core.inputports.IUpcomingAppointmentsQuery;
import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;
import com.pinkspring.doctorbooking.management.internal.core.outputports.IAppointmentRepo;
import com.pinkspring.doctorbooking.management.internal.shell.application.IUpcomingSlotsGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UpcomingAppointmentsQuery implements IUpcomingAppointmentsQuery {
    private final IAppointmentRepo appointmentRepo;
    private final IUpcomingSlotsGateway slotsGateway;

    public UpcomingAppointmentsQuery(IAppointmentRepo appointmentRepo, IUpcomingSlotsGateway slotsGateway) {
        this.appointmentRepo = appointmentRepo;
        this.slotsGateway = slotsGateway;
    }

    @Override
    public List<Appointment> getUpcomingDoctorsAppointments() {
        List<SlotDTO> upcomingSlots = slotsGateway.getAllUpcomingSlots();
        List<UUID> slotIds = upcomingSlots.stream().map(SlotDTO::id).toList();
        return appointmentRepo.getAppointmentsBySlotIds(slotIds);
    }
}
