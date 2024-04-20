package com.satish.apps.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserModel {

	@NotNull(message = "First name can not be null")
	private String firstName;
	
	@NotNull(message = "Last name can not be null")
	private String lastName;
	@Email(message = "Email not valid")
	private String email;
	
	@Size(min = 4, max = 50, message = "UserId can not be less than 4 and greater than 15")
	private String userId;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "UserModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", userId=" + userId + "]";
	}
	
	
	
}
