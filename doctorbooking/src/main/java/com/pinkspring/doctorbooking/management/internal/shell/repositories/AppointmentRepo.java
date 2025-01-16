package com.pinkspring.doctorbooking.management.internal.shell.repositories;

import com.pinkspring.doctorbooking.management.internal.core.models.Appointment;
import com.pinkspring.doctorbooking.management.internal.core.outputports.IAppointmentRepo;
import com.pinkspring.doctorbooking.management.internal.shell.db.AppointmentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AppointmentRepo implements IAppointmentRepo {
    private final JpaAppointmentRepo jpaAppointmentRepo;
    public AppointmentRepo(JpaAppointmentRepo jpaAppointmentRepo) {
        this.jpaAppointmentRepo = jpaAppointmentRepo;
    }

    @Override
    public List<Appointment> getAllDoctorsAppointments() {
        //TODO get all upcoming slots from availability module then get appointments for those slots
        return null;
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
