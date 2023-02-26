package com.project.exercise.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.project.exercise.validator.PersonValidator;

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

		validator.isValid(this);
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		validator.isValidName(name);
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		validator.isValidName(name);
		this.lastName = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public String getSocialNumber() {
		return socialNumber;
	}

	public Household getHousehold() {
		return household;
	}

	public void setHousehold(Household household) {
		this.household = household;
	}

	public List<Employment> getEmployments() {
		return employments;
	}

	public List<Employment> getCurrentEmployments() {
		return employments.stream().filter(Employment::isActive).toList();
	}

	public void setEmployments(List<Employment> employments) {
		this.employments = employments;
	}

	public void addEmployment(Employment employment) {
		this.employments.add(employment);
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
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

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", socialNumber=" + socialNumber
				+ ", household=" + household + ", employments=" + employments + ", loans=" + loans + "]";
	}
}
