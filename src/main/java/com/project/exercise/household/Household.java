package com.project.exercise.household;

import java.util.ArrayList;
import java.util.List;

import com.project.exercise.address.Address;
import com.project.exercise.employment.Employment;
import com.project.exercise.loan.Loan;
import com.project.exercise.person.Person;

public class Household {
	private List<Person> members = new ArrayList<>();
	private Address address;

	public Household(Address address) {
		this.address = address;
	}

	public List<Person> getMembers() {
		return members;
	}

	public void setMembers(List<Person> members) {
		this.members = members;
	}

	public void addMember(Person member) {
		members.add(member);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Person> getAdults() {
		return members.stream().filter(member -> member.isAdult()).toList();
	}

	public List<Person> getMinors() {
		return members.stream().filter(member -> !member.isAdult()).toList();
	}

	/**
	 * Calculates household adults summed up monthly incomes.
	 * 
	 * @return
	 */
	public long getHouseholdIncomes() {
		int incomes = 0;
		List<Person> adults = members.stream().filter(Person::isAdult).toList();

		for (Person adult : adults) {
			for (Employment employment : adult.getEmployments()) {
				if (employment.isActive()) {
					incomes += employment.getMonthlyIncome();
				}
			}
		}
		return incomes;
	}

	/**
	 * Calculates household members summed up monthly loan payments.
	 * 
	 * @return
	 */
	public long getHouseholdMonthlyLoanPayments() {
		int payments = 0;

		for (Person person : members) {
			for (Loan loan : person.getLoans()) {
				payments += loan.getMonthlyPayment();

			}
		}
		return payments;
	}

}
