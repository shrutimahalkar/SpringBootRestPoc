package com.springBootRest.service;

import java.util.List;

import com.springBootRest.entities.UserMaster;

public interface UserService {

	public UserMaster createUser(UserMaster user);
	public List<UserMaster> getAllUser();
}
