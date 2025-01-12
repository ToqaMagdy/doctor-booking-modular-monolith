package com.pinkspring.doctorbooking.availability.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "slot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Slot  {
    @Id
    private UUID id;
    private LocalDateTime date;
    private UUID doctorId;
    private Boolean isReserved;
    private Double cost;
}
