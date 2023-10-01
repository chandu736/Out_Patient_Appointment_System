package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Appointment;
import com.nt.model.Doctor;

@RestController
@RequestMapping("/api")
public class DoctorController {

    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    
    // Endpoint to list all doctors
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Endpoint to get details of a specific doctor by ID
    @GetMapping("/doctors/{id}")
    public Doctor getDoctor(@PathVariable int id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Endpoint to book an appointment with a doctor
    @PostMapping("/appointments")
    public String bookAppointment(@RequestBody Appointment appointment) {
        Doctor doctor = doctors.stream()
                .filter(d -> d.getId() == appointment.getDoctorId())
                .findFirst()
                .orElse(null);

        if (doctor == null) {
            return "Doctor not found";
        }

        // Check if the doctor's schedule allows for more appointments
        long bookedAppointments = appointments.stream()
                .filter(a -> a.getDoctorId() == appointment.getDoctorId())
                .count();

        if (bookedAppointments >= doctor.getMaxPatientsPerDay()) {
            return "Doctor is fully booked for the day";
        }

        appointments.add(appointment);
        return "Appointment booked successfully";
    }
}
