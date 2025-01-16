package com.pinkspring.doctorbooking.availability.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SlotRepository extends JpaRepository<Slot, UUID> {
    @Query(value ="select s.id,s.doctorName, s.isReserved, s.time, s.cost from Slot s where s.isReserved = false", nativeQuery = true)
    List<Slot> findDoctorAvailableSlots();

    @Query(value ="select s.id,s.doctorName, s.isReserved, s.time, s.cost from Slot s where s.time > CURRENT_TIMESTAMP", nativeQuery = true)
    List<Slot> findUpComingSlots();
}
