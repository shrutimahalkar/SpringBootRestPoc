package com.springBootRest.common;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class UserMasterBean {
	
	@JsonPropertyDescription("USERNAME")
	@JsonProperty("userName")
	@NonNull
	private String userName;
	
	@JsonPropertyDescription("PASSWORD")
	@JsonProperty("password")
	@NonNull
	private String password;

}
