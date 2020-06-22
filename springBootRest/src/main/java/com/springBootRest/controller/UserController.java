package com.springBootRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBootRest.entities.UserMaster;
import com.springBootRest.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserMaster>> getallUser(){
		return ResponseEntity.ok().body(userService.getAllUser());
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<UserMaster> createUser(@RequestBody UserMaster user){
		return ResponseEntity.ok().body(userService.createUser(user));
	}
}
