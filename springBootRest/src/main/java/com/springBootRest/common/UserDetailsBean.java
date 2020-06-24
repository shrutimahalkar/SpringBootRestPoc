package com.springBootRest.common;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserDetailsBean {
	
	@JsonPropertyDescription("FIRST NAME")
	@JsonProperty("firstName")
	@NonNull
	private String firstName;
	
	@JsonPropertyDescription("LAST NAME")
	@JsonProperty("lastName")
	@NonNull
	private String lastName;
	
	@JsonPropertyDescription("EMAIL")
	@JsonProperty("email")
	@NonNull
	private String email;
	
	@JsonPropertyDescription("PINCODE")
	@JsonProperty("pincode")
	@NonNull
	private String pincode;
	
	@JsonPropertyDescription("DATE OF BIRTH")
	@JsonProperty("dateOfBirth")
	@NonNull
	private String dateOfBirth;
	
	@JsonPropertyDescription("DATE OF JOINING")
	@JsonProperty("dateOfJoining")
	@NonNull
	private String dateOfJoining;

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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	
	

}
