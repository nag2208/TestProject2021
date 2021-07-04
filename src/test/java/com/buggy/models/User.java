package com.buggy.models;

import java.util.Random;

public class User {

	String firstName;
	String lastName;
	String gender;
	String age;
	String address;
	String phone;
	String password;

	public String getRandomUserName() {	
		Random objGenerator = new Random();
		int randomNumber = objGenerator.nextInt(1000);
		return "user" + String.valueOf(randomNumber);
	}

	public void setRandomUserName(String randomUserName) {
		this.randomUserName = randomUserName;
	}

	String confirmPassword;
	String randomUserName;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// profile
	public User(String firstName, String lastName, String gender, String age, String address, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;		
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}

	// registration
	public User(String firstName, String lastName, String password, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public User() {
	}

}
