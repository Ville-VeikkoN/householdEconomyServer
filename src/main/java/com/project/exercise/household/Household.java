package com.project.exercise.household;

import java.util.List;

import com.project.exercise.address.Address;
import com.project.exercise.person.Person;

public class Household {
	private List<Person> members;
	private Address address;
	
	public Household(Address address) {
	//	this.members = members;
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
	
}
