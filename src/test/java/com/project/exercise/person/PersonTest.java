package com.project.exercise.person;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.project.exercise.address.Address;
import com.project.exercise.employment.Employment;
import com.project.exercise.employment.Role;
import com.project.exercise.household.Household;
import com.project.exercise.loan.Loan;
import com.project.exercise.loan.LoanType;

class PersonTest {

	static Person adult;
	static Person minor;

	@BeforeAll
	public static void setUp() {
		adult = new Person("EtuNimi", "Sukunimi", Gender.MALE, "010101-010A", LocalDate.of(1993, 8, 25));
		minor = new Person("EtuNimi", "Sukunimi", Gender.MALE, "010101-010A", LocalDate.of(2007, 1, 12));

		Address address = new Address("Tampere", "Tamperekatu 1 A 1", "00100", "Tampere");
		Employment currentEmployment = new Employment(Role.EMPLOYEE, "Yritys", address, LocalDate.of(2023, 2, 25),
				2800);
		Employment earlierEmployment = new Employment(Role.ENTREPRENEUR, "Vanha Yritys", address,
				LocalDate.of(2018, 3, 5), 2640);
		earlierEmployment.setEndDate(LocalDate.of(2023, 2, 24));

		Address homeAddress = new Address("Pirkkala", "Pirkkalakatu 2 B 2", "00200", "Pirkkala");
		Household household = new Household(homeAddress);
		household.addMember(adult);
		household.addMember(minor);

		Loan mortage = new Loan(LoanType.MORTAGE, 270000, 0.59, (12 * 33));
		Loan carLoan = new Loan(LoanType.CAR_LOAN, 15000, 5.4, (12 * 5));

		adult.addEmployment(earlierEmployment);
		adult.addEmployment(currentEmployment);
		adult.setHousehold(household);
		adult.addLoan(mortage);
		adult.addLoan(carLoan);
	}

	@Test
	public void testPerson() {

		assertEquals(29, adult.getAge());
		assertEquals(16, minor.getAge());

		assertFalse(minor.isAdult());
		assertTrue(adult.isAdult());
	}

	@Test
	public void testInvalidPerson() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Person("Etu-Nimi", "Sukunimi", null, "0S50A", LocalDate.of(1993, 8, 25))
				, "Expected IllegalArgumentException");
	}

	@Test
	public void testAddress() {
		assertEquals("Pirkkalakatu 2 B 2", adult.getHousehold().getAddress().getStreetAddress());
	}

	@Test
	public void testEmployment() {
		List<Employment> currentEmployments = adult.getCurrentEmployments();
		assertEquals(1, currentEmployments.size());
		assertEquals(currentEmployments.get(0).getRole(), Role.EMPLOYEE);
		assertEquals(currentEmployments.get(0).getPost(), "Yritys");
	}

	@Test
	public void testHousehold() {
		Household household = adult.getHousehold();
		assertEquals(2, household.getMembers().size());
		assertEquals(2800, household.getHouseholdIncomes());
		assertEquals(1035, household.getHouseholdMonthlyLoanPayments());

		Person secondAdult = new Person("Uusi-Jäsen", "Esimerkki", Gender.FEMALE, "010101-010B",
				LocalDate.of(1993, 8, 21));
		Loan carLoan = new Loan(LoanType.CAR_LOAN, 10000, 5.4, (12 * 4));
		secondAdult.addLoan(carLoan);

		household.addMember(secondAdult);
		assertEquals(1267, household.getHouseholdMonthlyLoanPayments());

		assertTrue(household.getAdults().containsAll(List.of(adult, secondAdult)));
		assertTrue(household.getMinors().contains(minor));
	}

	@Test
	public void testLoan() {
		Loan loanWithoutInterest = new Loan(LoanType.OTHER, 12000, 0.0, 12);
		assertEquals(1000, loanWithoutInterest.getMonthlyPayment());

		Loan loanWitInterest = new Loan(LoanType.OTHER, 100000, 8.3, 180);
		assertEquals(973, loanWitInterest.getMonthlyPayment());
	}

}
