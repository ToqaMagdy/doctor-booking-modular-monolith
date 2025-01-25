package com.pinkspring.doctorbooking.availability.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SlotsRepository extends JpaRepository<Slots, UUID> {
    @Query(value ="select s.id,s.doctorName, s.doctorId, s.isReserved, s.time, s.cost from Slots s where s.isReserved = false", nativeQuery = true)
    List<Slots> findDoctorAvailableSlots();

    @Query(value ="select s.id,s.doctorName, s.isReserved, s.time, s.cost from Slots s where s.time > CURRENT_TIMESTAMP", nativeQuery = true)
    List<Slots> findUpComingSlots();
}
