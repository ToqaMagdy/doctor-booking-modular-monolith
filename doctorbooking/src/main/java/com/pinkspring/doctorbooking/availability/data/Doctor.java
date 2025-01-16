package com.pinkspring.doctorbooking.availability.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "doctor")
@Getter
@Setter
public class Doctor {
    @Id
    private UUID id;
    private String name;

}
