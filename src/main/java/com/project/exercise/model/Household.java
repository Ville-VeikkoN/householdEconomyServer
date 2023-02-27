package com.project.exercise.model;

import java.util.ArrayList;

import java.util.List;
import lombok.Data;

@Data
public class Household {

	private List<Person> members = new ArrayList<>();
	private Address address;

	public Household(Address address) {
		this.address = address;
	}

	public void addMember(Person member) {
		members.add(member);
	}

	public List<Person> getAdults() {
		return members.stream().filter(member -> member.isAdult()).toList();
	}

	public List<Person> getMinors() {
		return members.stream().filter(member -> !member.isAdult()).toList();
	}

	public int getHouseholdIncomes() {
		List<Employment> allActiveEmployments = members.stream().filter(Person::isAdult).map(Person::getEmployments)
				.flatMap(List::stream).filter(Employment::isActive).toList();

		return allActiveEmployments.stream().mapToInt(Employment::getMonthlyIncome).sum();
	}

	public int getHouseholdMonthlyLoanPayments() {
		return members.stream().map(Person::getLoans).flatMap(List::stream).mapToInt(Loan::getMonthlyPayment).sum();
	}

}
