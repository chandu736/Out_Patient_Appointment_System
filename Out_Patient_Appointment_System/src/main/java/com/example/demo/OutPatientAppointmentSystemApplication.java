package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.nt.app.repository")
public class OutPatientAppointmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutPatientAppointmentSystemApplication.class, args);
	}

}
