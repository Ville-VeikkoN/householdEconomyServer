package com.project.exercise.person;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.project.exercise.address.Address;
import com.project.exercise.employment.Employment;
import com.project.exercise.employment.Role;
import com.project.exercise.household.Household;

class PersonTest {

	@Test
	void test() {
		Person person = new Person("Etu-Nimi", "Sukunimi", Gender.MALE, "010101-010A", LocalDate.of(1993, 3, 11));
		
		Address address = new Address("Tampere", "Tamperekatu 1 A 1", "00100", "Tampere");
		Employment employment = new Employment(Role.EMPLOYEE, "Yritys", address, LocalDate.of(2021, 2, 20), 3.2);
		
		Address homeAddress = new Address("Pirkkala", "Pirkkalakatu 2 B 2", "00200", "Pirkkala");
		Household household = new Household(homeAddress);
		
		person.addEmployment(employment);
		person.setHousehold(household);
	}

}
