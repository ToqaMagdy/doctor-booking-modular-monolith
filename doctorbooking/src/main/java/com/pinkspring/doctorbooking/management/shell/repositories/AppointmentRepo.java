package com.pinkspring.doctorbooking.management.shell.repositories;

import com.pinkspring.doctorbooking.management.core.models.Appointment;
import com.pinkspring.doctorbooking.management.core.outputports.IAppointmentRepo;
import com.pinkspring.doctorbooking.management.shell.db.AppointmentEntity;
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
    public List<Appointment> getAllDoctorsAppointments(UUID doctorId) {
        //should we get all slots with doctorId and then get all appointments with those slots?
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
