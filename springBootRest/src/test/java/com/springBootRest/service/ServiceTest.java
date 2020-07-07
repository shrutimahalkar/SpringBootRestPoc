package com.springBootRest.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.springBootRest.common.DashboardResponse;
import com.springBootRest.model.UserDetails;
import com.springBootRest.model.UserEmployementDetails;
import com.springBootRest.model.UserMaster;
import com.springBootRest.repository.UserDetailsRepository;
import com.springBootRest.serviceImpl.UserServiceImpl;

public class ServiceTest {
	@Mock
	private static UserDetailsRepository userRepo;


	@Test
	public void test() {
		fail("Not yet implemented");
		assertTrue(true);
	}
	@InjectMocks
	private static UserService serviceImpl = new UserServiceImpl();

	
	UserMaster userMaster= null;
	UserMaster failMasterEntity = null;
	 DashboardResponse resMsg = null;
	 DashboardResponse failResMsg = null;
	UserDetails userDetails = null;
	UserDetails ufailDetailsentity = null;
	UserEmployementDetails userEmployementDetails =null;

	String fname = "Ram";
	String lname = "Kumar";
	List<UserDetails> list = null;
	
	@BeforeEach
	public void setUpForTestin() {

		userMaster = new UserMaster();
		userMaster.setUserMasterId(1);
		userMaster.setUserName("shruti1234");
		userMaster.setPassword("1234");
		
		userEmployementDetails = new UserEmployementDetails();
		userEmployementDetails.setEmpId(2);
		userEmployementDetails.setCompanyName("Neo");
		userEmployementDetails.setLocation("panvel");
		failMasterEntity = new UserMaster();
		failMasterEntity.setUserMasterId(1);
		failMasterEntity.setUserName("Amit");
		failMasterEntity.setPassword("78Am");
		userDetails = new UserDetails();
		userDetails.setUserId(2);
		userDetails.setFirstName("shruti");
		userDetails.setLastName("mahalkar");
		userDetails.setEmail("mahalkar@gmail.com");
		userDetails.setUserMaster(userMaster);
		userDetails.setUserEmployementDetails(userEmployementDetails);
		list = new ArrayList<>();
		list.add(userDetails);

	}

	@Test
	public void getAllUsers() throws Exception {
		Mockito.when(userRepo.findAll()).thenReturn(list);
		assertEquals(list, serviceImpl.getAllUsers());
	}
	
}
