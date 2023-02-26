package com.project.exercise.model;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPostalDistrict() {
		return postalDistrict;
	}

	public void setPostalDistrict(String postalDistrict) {
		this.postalDistrict = postalDistrict;
	}

}
