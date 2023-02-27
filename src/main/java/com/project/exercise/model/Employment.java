package com.project.exercise.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Employment {

	private EmploymentRole role;
	private String post;
	private Address address;
	private final LocalDate startDate;
	private LocalDate endDate;
	private int monthlyIncome;

	public Employment(EmploymentRole role, String post, Address address, LocalDate startDate, int monthlyIncome) {
		this.role = role;
		this.post = post;
		this.address = address;
		this.startDate = startDate;
		this.monthlyIncome = monthlyIncome;
	}

	public boolean isActive() {
		return endDate == null || endDate.isAfter(LocalDate.now());
	}

	public Long getDurationInMonths() {
		LocalDate now = LocalDate.now();
		long months = java.time.temporal.ChronoUnit.MONTHS.between(startDate, now);
		return months;
	}

}
