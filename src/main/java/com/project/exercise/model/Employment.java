package com.project.exercise.model;

import java.time.LocalDate;

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

	public EmploymentRole getRole() {
		return role;
	}

	public void setRole(EmploymentRole role) {
		this.role = role;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(int monthlyIncome) {
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
