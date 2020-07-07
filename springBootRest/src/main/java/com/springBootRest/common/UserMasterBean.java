package com.springBootRest.common;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class UserMasterBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@JsonPropertyDescription("USERID")
	@JsonProperty("userId")
	@NonNull
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
