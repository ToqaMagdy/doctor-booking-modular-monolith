package com.pinkspring.doctorbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.modulith.Modulithic;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;


@Modulithic
@SpringBootApplication
@ConfigurationPropertiesScan
public class DoctorBookingApplication {
	public static void main(String[] args) {
		SpringApplication.run(DoctorBookingApplication.class, args);
		var modules = ApplicationModules.of(DoctorBookingApplication.class);
		modules.forEach(System.out::println);
		new Documenter(modules).writeDocumentation();

	}

}
