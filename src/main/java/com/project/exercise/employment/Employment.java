package com.project.exercise.employment;

import java.time.LocalDate;

import com.project.exercise.address.Address;

public class Employment {

	/**
	 * Role in this employment
	 */
	private Role role;
	/**
	 * Name of the school or company
	 */
	private String post;
	/**
	 * Address of the school or company
	 */
	private Address address;
	/**
	 * Start date
	 */
	private LocalDate startDate;
	/**
	 * End date
	 */
	private LocalDate endDate;
	/**
	 * Monthly income
	 */
	private Double monthlyIncome;
	
	public Employment(Role role, String post, Address address, LocalDate startDate, Double monthlyIncome) {
		this.role = role;
		this.post = post;
		this.address = address;
		this.startDate = startDate;
		this.monthlyIncome = monthlyIncome;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
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

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public boolean isActive() {
		return endDate == null;
	}
	
	public Long getDurationInMonths() {
		LocalDate now = LocalDate.now();
		long months = java.time.temporal.ChronoUnit.MONTHS.between(startDate, now);
		return months;
	}

}
