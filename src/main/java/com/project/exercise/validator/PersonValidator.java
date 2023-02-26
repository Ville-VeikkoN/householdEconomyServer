package com.project.exercise.validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.project.exercise.person.Gender;
import com.project.exercise.person.Person;

public final class PersonValidator {

	public final boolean isValid(Person person) {
		List<String> errors = new ArrayList<>();

		if (!isValidName(person.getFirstName())) {
			errors.add(String.format("First name %s should contain only letters", person.getFirstName()));
		}

		if (!isValidName(person.getLastName())) {
			errors.add(String.format("Last name %s should contain only letters", person.getFirstName()));
		}

		if (!isValidGender(person.getGender())) {
			errors.add("Gender should not be null");
		}

		if (!isValidSocialNumber(person.getSocialNumber())) {
			errors.add(String.format("Social number %s is invalid", person.getSocialNumber()));
		}

		if (!isValidDateOfBirth(person.getDateOfBirth())) {
			errors.add(String.format("Social number %s is invalid", person.getSocialNumber()));

		}

		if (!errors.isEmpty()) {
			throw new IllegalArgumentException(errors.toString());
		}

		return true;
	}

	public boolean isValidGender(Gender gender) {
		return gender != null;
	}

	public boolean isValidDateOfBirth(LocalDate birth) {
		return birth != null && birth.isBefore(LocalDate.now());
	}

	public boolean isValidSocialNumber(String socialNumber) {
		if (socialNumber.isBlank()) {
			return false;
		}
		String[] split = socialNumber.split("-");
		return split.length == 2 && split[0].length() == 6 && containsOnlyDigits(split[0]) && split[1].length() == 4
				&& containsOnlyLettersOrDigits(split[1]);
	}

	public boolean isValidName(String name) {
		return !name.isBlank();
	}

	public boolean containsOnlyDigits(String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public boolean containsOnlyLettersOrDigits(String s) {
		for (char c : s.toCharArray()) {
			if (!(Character.isLetterOrDigit(c) || c != '-')) {
				return false;
			}
		}
		return true;
	}

}