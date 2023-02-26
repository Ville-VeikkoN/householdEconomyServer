package com.project.exercise.validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.project.exercise.model.Gender;
import com.project.exercise.model.Person;

public final class PersonValidator {

	private final String NAME_REGEX = "^[a-zäöA-ZÄÖ]+(([',. -][a-zäöA-ZÄÖ ])?[a-zäöA-ZÄÖ]*)*$";
	private final String SOCIAL_REGEX = "^[0-9]{6,}[-][a-zA-Z0-9]{4,}";

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
			errors.add(String.format("Date of birth %s is invalid", person.getDateOfBirth()));

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
		return socialNumber.matches(SOCIAL_REGEX);
	}

	public boolean isValidName(String name) {
		return !name.isBlank() && name.matches(NAME_REGEX);
	}

}