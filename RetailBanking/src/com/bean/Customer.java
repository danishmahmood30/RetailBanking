package com.bean;

import java.math.BigInteger;

public class Customer {
	private int customerId;
	private long aadhaar;
	private String name;
	private int age;
	private String address1;
	private String address2;
	private String city;
	private String state;
	
	public Customer(long aadhaar, String name, int age, String address1, String address2, String city,
			String state) {
		super();
		this.customerId = 0;
		this.aadhaar = aadhaar;
		this.name = name;
		this.age = age;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
	}

	public Customer() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(long aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
