package com.project.exercise.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.project.exercise.validator.PersonValidator;

import lombok.Data;

@Data
public class Person {

	private final PersonValidator validator = new PersonValidator();

	private String firstName;
	private String lastName;
	private final LocalDate dateOfBirth;
	private final Gender gender;
	private final String socialNumber;
	private Household household;
	private List<Employment> employments = new ArrayList<>();
	private List<Loan> loans = new ArrayList<>();

	public Person(String firstName, String lastName, Gender gender, String socialNumber, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.socialNumber = socialNumber;
		this.dateOfBirth = dateOfBirth;

		this.validator.validate(this);
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
		this.validator.validate(this);
	}

	public void setLastName(String name) {
		this.lastName = name;
		this.validator.validate(this);
	}

	public List<Employment> getCurrentEmployments() {
		return employments.stream().filter(Employment::isActive).toList();
	}

	public void addEmployment(Employment employment) {
		this.employments.add(employment);
	}

	public void addLoan(Loan loan) {
		this.loans.add(loan);
	}

	public int getAge() {
		LocalDate now = LocalDate.now();
		long years = java.time.temporal.ChronoUnit.YEARS.between(dateOfBirth, now);
		return (int) years;
	}

	public boolean isAdult() {
		return getAge() >= 18;
	}

}
