package com.springBootRest.common;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserDetailsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonPropertyDescription("USERID")
	@JsonProperty("userId")
	private String userId;
	
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
	@Pattern(regexp ="^([A-Za-z0-9])(([.])?[0-9a-z])*[@]([a-z])+([.]([a-z])+){1,3}", message = "invalid email")
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
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
