package com.nt.model;
import lombok.Data;
@Data
public class Appointment {
	private int doctorId;
    private String patientName;
    private String appointmentTime;
}
