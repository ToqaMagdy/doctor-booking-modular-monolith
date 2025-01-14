package com.pinkspring.doctorbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;
import org.springframework.modulith.core.ApplicationModules;


@Modulithic
@SpringBootApplication
public class DoctorBookingApplication {
	public static void main(String[] args) {
		SpringApplication.run(DoctorBookingApplication.class, args);
		var modules = ApplicationModules.of(DoctorBookingApplication.class);
		modules.forEach(System.out::println);
	}

}
