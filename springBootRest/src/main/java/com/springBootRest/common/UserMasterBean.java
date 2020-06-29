package com.springBootRest.common;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class UserMasterBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@JsonPropertyDescription("USERMASTERID")
	@JsonProperty("userMasterId")
	@NonNull
	private String userMasterId;
	
	@JsonPropertyDescription("USERNAME")
	@JsonProperty("userName")
	@NonNull
	private String userName;
	
	@JsonPropertyDescription("PASSWORD")
	@JsonProperty("password")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
