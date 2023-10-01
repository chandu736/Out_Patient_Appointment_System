package com.nt.model;

import java.util.List;

import lombok.Data;

@Data
public class Doctor {
	private int id;
    private String name;
    private String specialty;
    private int maxPatientsPerDay;
    private List<String> schedule;
}
