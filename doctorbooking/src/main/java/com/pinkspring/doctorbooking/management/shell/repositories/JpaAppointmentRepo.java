package com.pinkspring.doctorbooking.management.shell.repositories;

import com.pinkspring.doctorbooking.management.core.models.Appointment;
import com.pinkspring.doctorbooking.management.shell.db.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface JpaAppointmentRepo extends JpaRepository<AppointmentEntity, UUID> {
}
