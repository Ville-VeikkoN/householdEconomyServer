package com.project.exercise.model;

import lombok.Data;

@Data
public class Address {

	private String city;
	private String streetAddress;
	private String postalCode;
	private String postalDistrict;

	public Address(String city, String streetAddress, String postalCode, String postalDistrict) {
		this.city = city;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.postalDistrict = postalDistrict;
	}
}
