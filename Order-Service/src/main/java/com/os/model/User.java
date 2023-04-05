package com.os.model;

import java.time.LocalDate;

public class User {

	private Long id;
	private String name;
	private LocalDate dob;
	private String address;

	public User(Long id, String name, LocalDate dob, String address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + "]";
	}

}
