package com.project.exercise.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.project.exercise.model.Address;
import com.project.exercise.model.Employment;
import com.project.exercise.model.EmploymentRole;
import com.project.exercise.model.Gender;
import com.project.exercise.model.Household;
import com.project.exercise.model.Loan;
import com.project.exercise.model.LoanType;
import com.project.exercise.model.Person;

class PersonTest {

	static Person adult;
	static Person minor;

	@BeforeAll
	public static void setUp() {
		//Persons
		adult = new Person("Etu-Nimi", "Sukunimi", Gender.MALE, "010101-010A", LocalDate.of(1993, 8, 25));
		minor = new Person("Toinen-Nimi", "Sukunimi", Gender.FEMALE, "020202-020B", LocalDate.of(2007, 1, 12));

		//Employments (and address)
		Address workAddress = new Address("Tampere", "Tamperekatu 1 A 1", "00100", "Tampere");
		Employment currentEmployment = new Employment(EmploymentRole.EMPLOYEE, "Yritys", workAddress,
				LocalDate.of(2022, 6, 25), 2800);
		Employment earlierEmployment = new Employment(EmploymentRole.ENTREPRENEUR, "Vanha Yritys", workAddress,
				LocalDate.of(2018, 3, 5), 2640);
		earlierEmployment.setEndDate(LocalDate.of(2022, 6, 24));
		adult.addEmployment(earlierEmployment);
		adult.addEmployment(currentEmployment);

		//Household (and address)
		Address homeAddress = new Address("Pirkkala", "Pirkkalakatu 2 B 2", "00200", "Pirkkala");
		Household household = new Household(homeAddress);
		household.addMember(adult);
		household.addMember(minor);
		adult.setHousehold(household);

		//Loans
		Loan mortage = new Loan(LoanType.MORTAGE, 270000, 0.59, (12 * 33));
		Loan carLoan = new Loan(LoanType.CAR_LOAN, 15000, 5.4, (12 * 5));
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
		
		//Illegal null gender
		IllegalArgumentException genderEx = assertThrows(IllegalArgumentException.class,
				() -> new Person("Etu-Nimi", "Sukunimi", null, "010101-101A", LocalDate.of(1993, 8, 25)),
				"Expected IllegalArgumentException");

		assertTrue(genderEx.getMessage().contains("Gender"));

		//Illegal social number (contains '?')
		IllegalArgumentException socialNumberEx = assertThrows(IllegalArgumentException.class,
				() -> new Person("Etu-Nimi", "Sukunimi", Gender.MALE, "010101-?01A", LocalDate.of(1993, 8, 25)),
				"Expected IllegalArgumentException");

		assertTrue(socialNumberEx.getMessage().contains("Social number"));

		//Illegal date of birth (future)
		IllegalArgumentException dateOfBirthEx = assertThrows(IllegalArgumentException.class,
				() -> new Person("Etu-Nimi", "Sukunimi", Gender.MALE, "010101-101A", LocalDate.of(2026, 1, 1)),
				"Expected IllegalArgumentException");

		assertTrue(dateOfBirthEx.getMessage().contains("Date of birth"));
	}

	@Test
	public void testAddress() {
		assertEquals("Pirkkalakatu 2 B 2", adult.getHousehold().getAddress().getStreetAddress());
	}

	@Test
	public void testEmployment() {
		List<Employment> currentEmployments = adult.getCurrentEmployments();
		assertEquals(1, currentEmployments.size());
		assertEquals(8, currentEmployments.get(0).getDurationInMonths());
		assertEquals(currentEmployments.get(0).getRole(), EmploymentRole.EMPLOYEE);
		assertEquals(currentEmployments.get(0).getPost(), "Yritys");
	}

	@Test
	public void testHousehold() {
		Household household = adult.getHousehold();
		assertEquals(2, household.getMembers().size());
		assertEquals(2800, household.getHouseholdIncomes());
		assertEquals(1035, household.getHouseholdMonthlyLoanPayments());

		// Test household with multiple adults
		Person secondAdult = new Person("Uusi-Jäsen", "Esimerkki", Gender.FEMALE, "010101-010B",
				LocalDate.of(1993, 8, 21));
		Loan carLoan = new Loan(LoanType.CAR_LOAN, 10000, 5.4, (12 * 4));
		secondAdult.addLoan(carLoan);

		household.addMember(secondAdult);
		assertEquals(1267, household.getHouseholdMonthlyLoanPayments());

		assertTrue(household.getAdults().containsAll(List.of(adult, secondAdult)));
		assertTrue(household.getMinors().contains(minor));

		// Test new empty household
		Address homeAddress = new Address("Pirkkala", "Pirkkalakatu 2 B 2", "00200", "Pirkkala");
		Household newEmptyHousehold = new Household(homeAddress);
		assertEquals(0, newEmptyHousehold.getHouseholdIncomes());
		assertEquals(0, newEmptyHousehold.getHouseholdMonthlyLoanPayments());

	}

	@Test
	public void testLoan() {
		assertEquals(2, adult.getLoans().size());
		
		Loan loanWithoutInterest = new Loan(LoanType.OTHER, 12000, 0.0, 12);
		assertEquals(1000, loanWithoutInterest.getMonthlyPayment());

		Loan loanWitInterest = new Loan(LoanType.OTHER, 100000, 8.3, 180);
		assertEquals(973, loanWitInterest.getMonthlyPayment());
	}

}
