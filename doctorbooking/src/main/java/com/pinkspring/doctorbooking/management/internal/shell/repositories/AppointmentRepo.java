package com.pinkspring.doctorbooking.management.internal.shell.repositories;

import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;
import com.pinkspring.doctorbooking.management.internal.core.outputports.IAppointmentRepo;
import com.pinkspring.doctorbooking.management.internal.shell.application.IUpcomingSlotsGateway;
import com.pinkspring.doctorbooking.management.internal.shell.db.AppointmentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AppointmentRepo implements IAppointmentRepo {
    private final JpaAppointmentRepo jpaAppointmentRepo;

    public AppointmentRepo(JpaAppointmentRepo jpaAppointmentRepo,
                           IUpcomingSlotsGateway slotsGateway) {
        this.jpaAppointmentRepo = jpaAppointmentRepo;
    }

    @Override
    public List<Appointment> getAppointmentsBySlotIds(List<UUID> slotIds) {
        return jpaAppointmentRepo.
                findBySlotIdIn(slotIds).stream()
                .map(AppointmentEntity::toDomain).toList();
    }

    @Override
    public Appointment getAppointmentById(UUID appointmentId) {
        return jpaAppointmentRepo.findById(appointmentId).map(AppointmentEntity::toDomain).orElse(null);
    }

    @Override
    public void save(Appointment appointment) {
        AppointmentEntity entity = AppointmentEntity.fromDomain(appointment);
        jpaAppointmentRepo.save(entity);
    }
}
