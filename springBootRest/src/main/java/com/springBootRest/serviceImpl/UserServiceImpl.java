package com.springBootRest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBootRest.entities.UserMaster;
import com.springBootRest.repository.UserMasterRepository;
import com.springBootRest.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMasterRepository userRepository;

	@Override
	public UserMaster createUser(UserMaster user) {
		UserMaster usermaster = new UserMaster();
		usermaster =userRepository.save(user);
		return usermaster;
		 
	}

	@Override
	public List<UserMaster> getAllUser() {
		List<UserMaster> userList=(List<UserMaster>) userRepository.findAll();
		return  userList;
	}

}
