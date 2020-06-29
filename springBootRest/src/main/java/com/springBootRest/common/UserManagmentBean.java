package com.springBootRest.common;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.Data;
import lombok.NonNull;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserManagmentBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonPropertyDescription("USER NAME")
	@JsonProperty("userName")
	@NonNull
	private String userName;
	
	@JsonPropertyDescription("FIRST NAME")
	@JsonProperty("firstName")
	@NonNull
	@Pattern(regexp ="([a-zA-Z]){2,16}", message = "invalid firstName")
	private String firstName;
	
	@JsonPropertyDescription("LAST NAME")
	@Pattern(regexp ="([a-zA-Z]){2,16}", message = "invalid lastName")
	@NonNull
	private String lastName;
	
	@JsonPropertyDescription("EMAIL")
	@JsonProperty("email")
	@NonNull
	@Pattern(regexp ="^([A-Za-z0-9])(([.])?[0-9a-z])*[@]([a-z])+([.]([a-z])+){1,3}", message = "invalid email")
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
	
	@JsonPropertyDescription("COMPANY NAME")
	@JsonProperty("companyName")
	@NonNull	private String companyName;

	@JsonPropertyDescription("LOCATION")
	@JsonProperty("location")
	@NonNull	private String location;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}