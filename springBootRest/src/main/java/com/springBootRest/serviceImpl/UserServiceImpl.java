package com.springBootRest.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBootRest.common.CommanConstant;
import com.springBootRest.common.DashboardResponse;
import com.springBootRest.common.UserDetailsBean;
import com.springBootRest.common.UserMasterBean;
import com.springBootRest.model.UserDetails;
import com.springBootRest.model.UserMaster;
import com.springBootRest.repository.UserDetailsRepository;
import com.springBootRest.repository.UserMasterRepository;
import com.springBootRest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();
	@Autowired
	private UserMasterRepository userMasterRepository;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public String getAllUsers() throws Exception {
		LOGGER.trace("Starting getAllUsers() from UserServiceImpl");
		String returnValue = null;
		String errorMsg = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		try {
			List<UserDetails> userDetailsList = this.userDetailsRepository.findAll();
			LOGGER.trace("USER_DETAILS_LIST:: " + userDetailsList);
			List<UserDetailsBean> userDetailsBeanList = new ArrayList<>();
			for (UserDetails userDetails : userDetailsList) {
				UserDetailsBean userDetailsBean = new UserDetailsBean();
				userDetailsBean.setFirstName(userDetails.getFirstName());
				userDetailsBean.setLastName(userDetails.getLastName());
				userDetailsBean.setEmail(userDetails.getEmail());
				userDetailsBean.setDateOfBirth(userDetails.getDateOfBirth().toString());
				userDetailsBean.setDateOfJoining(userDetails.getDateOfJoining().toString());
				userDetailsBean.setPincode(userDetails.getPincode());
				userDetailsBeanList.add(userDetailsBean);
			}
			if (!userDetailsBeanList.isEmpty()) {
				dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
				dashboardResponse.setResponseData("USER", userDetailsBeanList);
			} else
				errorMsg = "No Records found for requested input.";

		} catch (Exception e) {
			errorMsg = "Following exception occur while fetching User.";
			LOGGER.error(errorMsg + "\n\r : " + e.getStackTrace());
		}
		if (errorMsg != null) {
			dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
			dashboardResponse.setErrorMsg(errorMsg);
		}
		returnValue = MAPPER.writeValueAsString(dashboardResponse);
		LOGGER.trace("Exiting getAllUsers() from UserServiceImpl with return:: returnValue: " + returnValue);
		return returnValue;
	}

	@Override
	public String createUser(String dashboardRequest) throws Exception {
		LOGGER.trace(
				"Starting createUser() from UserServiceImpl with arguments:: dashboardRequest: " + dashboardRequest);
		String returnValue = null;
		String errorMsg = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		try {
			JsonNode requestJsonNode = MAPPER.readTree(dashboardRequest);
			String userName = requestJsonNode.get("userName").asText();
			String password = requestJsonNode.get("password").asText();
			UserMaster userMaster = new UserMaster();
			userMaster.setUserName(userName);
			userMaster.setPassword(password);
			userMaster.setIsActive(true);

			userMaster = this.userMasterRepository.save(userMaster);
			if (userMaster != null) {
				dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
				dashboardResponse.setResponseData("USER", userMaster);
			} else
				errorMsg = "No Records found.";

		} catch (Exception e) {
			errorMsg = "Following exception occur while CreatingNew User.";
			LOGGER.error(errorMsg + "\n\r : " + e.getStackTrace());
		}
		if (errorMsg != null) {
			dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
			dashboardResponse.setErrorMsg(errorMsg);
		}
		returnValue = MAPPER.writeValueAsString(dashboardResponse);
		LOGGER.trace("Exiting createUser() from UserServiceImpl with return:: returnValue: " + returnValue);
		return returnValue;
	}

	@Override
	public String saveUserdetails(String dashboardRequest) throws Exception {
		LOGGER.trace("Starting saveUserdetails() from UserServiceImpl with arguments:: dashboardRequest: "
				+ dashboardRequest);
		String returnValue = null;
		String errorMsg = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		try {
			JsonNode requestJsonNode = MAPPER.readTree(dashboardRequest);
			String userName = requestJsonNode.get("userName").asText();
			String password = requestJsonNode.get("password").asText();
			UserMaster userMaster = new UserMaster();
			userMaster.setUserName(userName);
			userMaster.setPassword(password);
			userMaster.setIsActive(true);

			userMaster = this.userMasterRepository.save(userMaster);

			UserDetails userDetails = new UserDetails();
			userDetails.setFirstName(requestJsonNode.get("firstName").asText());
			userDetails.setLastName(requestJsonNode.get("lastName").asText());

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			userDetails.setDateOfBirth(df.parse(requestJsonNode.get("dateOfBirth").asText()));
			userDetails.setDateOfJoining(df.parse(requestJsonNode.get("dateOfJoining").asText()));
			userDetails.setEmail(requestJsonNode.get("email").asText());
			userDetails.setPincode(requestJsonNode.get("pincode").asText());
			userDetails.setActive(true);
			userDetails.setUserMaster(userMaster);
			userDetails = this.userDetailsRepository.save(userDetails);
			if (userDetails != null) {
				dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
				dashboardResponse.setResponseData("USER", "User Successfully get Created");
			} else
				errorMsg = "No Records found for Username";

		} catch (Exception e) {
			errorMsg = "Following exception occur while fetching User Details.";
			LOGGER.error(errorMsg + "\n\r : " + e.getStackTrace());
		}
		if (errorMsg != null) {
			dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
			dashboardResponse.setErrorMsg(errorMsg);
		}
		returnValue = MAPPER.writeValueAsString(dashboardResponse);
		LOGGER.trace("Exiting saveUserdetails() from UserServiceImpl with return:: returnValue: " + returnValue);
		return returnValue;
	}

	@Override
	public String searchFnameLnamePin(String dashboardRequest) throws Exception {
		LOGGER.trace("Starting searchFnameLnamePin() from UserServiceImpl with arguments:: dashboardRequest: "
				+ dashboardRequest);
		String returnValue = null;
		String errorMsg = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		try {
			JsonNode jsonstring = MAPPER.readTree(dashboardRequest);
			String fName = jsonstring.get("firstName").asText();
			String lName = jsonstring.get("lastName").asText();
			String pin = jsonstring.get("pincode").asText();

			List<UserDetails> userDetailsList = this.userDetailsRepository.findByFirstNameOrLastNameOrPincode(fName,
					lName, pin);
			List<UserDetailsBean> userDetailsBeanList = new ArrayList<>();
			for (UserDetails userDetails : userDetailsList) {
				UserDetailsBean userDetailsBean = new UserDetailsBean();
				userDetailsBean.setFirstName(userDetails.getFirstName());
				userDetailsBean.setLastName(userDetails.getLastName());
				userDetailsBean.setEmail(userDetails.getEmail());
				userDetailsBean.setDateOfBirth(userDetails.getDateOfBirth().toString());
				userDetailsBean.setDateOfJoining(userDetails.getDateOfJoining().toString());
				userDetailsBean.setPincode(userDetails.getPincode());
				userDetailsBeanList.add(userDetailsBean);
			}
			if (userDetailsBeanList != null) {
				dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
				dashboardResponse.setResponseData("USERS", userDetailsBeanList);
			} else
				errorMsg = "No Records found for Username";

		} catch (Exception e) {
			errorMsg = "Following exception occur while fetching User Details.";
			LOGGER.error(errorMsg + "\n\r : " + e.getStackTrace());
		}
		if (errorMsg != null) {
			dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
			dashboardResponse.setErrorMsg(errorMsg);
		}
		returnValue = MAPPER.writeValueAsString(dashboardResponse);
		LOGGER.trace("Exiting searchFnameLnamePin() from UserServiceImpl with return:: returnValue: " + returnValue);
		return returnValue;
	}

	@Override
	public String editUserDetails(String dashboardRequest) throws Exception {
		LOGGER.trace("Starting editUserDetails() from UserServiceImpl with arguments:: dashboardRequest: "
				+ dashboardRequest);
		String returnValue = null;
		String errorMsg = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		try {
			JsonNode jsonstring = MAPPER.readTree(dashboardRequest);
			int id = jsonstring.get("userId").asInt();

			UserDetails userDetails = this.userDetailsRepository.findByUserId(id);
			// UserMaster userMaster =
			// this.userMasterRepository.findByUserMasterId(id);

			if (userDetails != null) {
				userDetails.setFirstName(jsonstring.get("firstName").asText());
				userDetails.setLastName(jsonstring.get("lastName").asText());
				userDetails = this.userDetailsRepository.save(userDetails);

				UserDetailsBean userDetailsBean = new UserDetailsBean();
				userDetailsBean.setFirstName(userDetails.getFirstName());
				userDetailsBean.setLastName(userDetails.getLastName());
				userDetailsBean.setEmail(userDetails.getEmail());
				userDetailsBean.setDateOfBirth(userDetails.getDateOfBirth().toString());
				userDetailsBean.setDateOfJoining(userDetails.getDateOfJoining().toString());
				userDetailsBean.setPincode(userDetails.getPincode());

				if (userDetails != null) {
					dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
					dashboardResponse.setResponseData("USERS", userDetailsBean);
				} else
					errorMsg = "Error occur while Updating User";
			} else
				errorMsg = "No Records found for Username";

		} catch (Exception e) {
			errorMsg = "Following exception occur while fetching User Details.";
			LOGGER.error(errorMsg + "\n\r : " + e.getStackTrace());
		}
		if (errorMsg != null) {
			dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
			dashboardResponse.setErrorMsg(errorMsg);
		}
		returnValue = MAPPER.writeValueAsString(dashboardResponse);
		LOGGER.trace("Exiting editUserDetails() from UserServiceImpl with return:: returnValue: " + returnValue);
		return returnValue;
	}

	@Override
	public String softDelete(String dashboardRequest) throws Exception {
		LOGGER.trace(
				"Starting softDelete() from UserServiceImpl with arguments:: dashboardRequest: " + dashboardRequest);
		String returnValue = null;
		String errorMsg = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		try {
			JsonNode requestJsonNode = MAPPER.readTree(dashboardRequest);
			int id = requestJsonNode.get("userMasterId").asInt();
			UserMaster userMaster = this.userMasterRepository.findByUserMasterId(id);
			userMaster.setIsActive(false);

			userMaster = this.userMasterRepository.save(userMaster);
			if (userMaster != null) {
				dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
				dashboardResponse.setResponseData("USER", "User Get Deactivated");
			} else
				errorMsg = "No Records found.";

		} catch (Exception e) {
			errorMsg = "Following exception occur while CreatingNew User.";
			LOGGER.error(errorMsg + "\n\r : " + e.getStackTrace());
		}
		if (errorMsg != null) {
			dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
			dashboardResponse.setErrorMsg(errorMsg);
		}
		returnValue = MAPPER.writeValueAsString(dashboardResponse);
		LOGGER.trace("Exiting softDelete() from UserServiceImpl with return:: returnValue: " + returnValue);
		return returnValue;
	}

	@Override
	public String hardDelete(String dashboardRequest) throws Exception {
		LOGGER.trace(
				"Starting hardDelete() from UserServiceImpl with arguments:: dashboardRequest: " + dashboardRequest);
		String returnValue = null;
		String errorMsg = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		try {
			JsonNode requestJsonNode = MAPPER.readTree(dashboardRequest);
			int id = requestJsonNode.get("userId").asInt();
			this.userDetailsRepository.deleteById(id);
			dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
			dashboardResponse.setResponseData("USER", "User Sucessfulyy Deleted");

		} catch (Exception e) {
			errorMsg = "Following exception occur while Deleting User.";
			LOGGER.error(errorMsg + "\n\r : " + e.getStackTrace());
		}
		if (errorMsg != null) {
			dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
			dashboardResponse.setErrorMsg(errorMsg);
		}
		returnValue = MAPPER.writeValueAsString(dashboardResponse);
		LOGGER.trace("Exiting hardDelete() from UserServiceImpl with return:: returnValue: " + returnValue);
		return returnValue;
	}

	@Override
	public String sortByDob() throws Exception {
		LOGGER.trace("Starting sortByDob() from UserServiceImpl");
		String returnValue = null;
		String errorMsg = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		try {

			List<UserDetails> sortedUsers = this.userDetailsRepository.sortByDob();
			List<UserDetailsBean> userDetailsBeanList = new ArrayList<>();
			for (UserDetails userDetails : sortedUsers) {
				UserDetailsBean userDetailsBean = new UserDetailsBean();
				userDetailsBean.setFirstName(userDetails.getFirstName());
				userDetailsBean.setLastName(userDetails.getLastName());
				userDetailsBean.setEmail(userDetails.getEmail());
				userDetailsBean.setDateOfBirth(userDetails.getDateOfBirth().toString());
				userDetailsBean.setDateOfJoining(userDetails.getDateOfJoining().toString());
				userDetailsBean.setPincode(userDetails.getPincode());
				userDetailsBeanList.add(userDetailsBean);
			}

			LOGGER.trace("USER_DETAILS_LIST:: " + userDetailsBeanList);
			if (!sortedUsers.isEmpty()) {
				dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
				dashboardResponse.setResponseData("USER", userDetailsBeanList);
			} else
				errorMsg = "No Records found for requested input.";

		} catch (Exception e) {
			errorMsg = "Following exception occur while fetching User.";
			LOGGER.error(errorMsg + "\n\r : " + e.getStackTrace());
		}
		if (errorMsg != null) {
			dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
			dashboardResponse.setErrorMsg(errorMsg);
		}
		returnValue = MAPPER.writeValueAsString(dashboardResponse);
		LOGGER.trace("Exiting sortByDob() from UserServiceImpl with return:: returnValue: " + returnValue);
		return returnValue;
	}

	@Override
	public String sortByDoj() throws Exception {
		LOGGER.trace("Starting sortByDoj() from UserServiceImpl");
		String returnValue = null;
		String errorMsg = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		try {

			List<UserDetails> sortedUsers = this.userDetailsRepository.sortByDoj();
			List<UserDetailsBean> userDetailsBeanList = new ArrayList<>();
			for (UserDetails userDetails : sortedUsers) {
				UserDetailsBean userDetailsBean = new UserDetailsBean();
				userDetailsBean.setFirstName(userDetails.getFirstName());
				userDetailsBean.setLastName(userDetails.getLastName());
				userDetailsBean.setEmail(userDetails.getEmail());
				userDetailsBean.setDateOfBirth(userDetails.getDateOfBirth().toString());
				userDetailsBean.setDateOfJoining(userDetails.getDateOfJoining().toString());
				userDetailsBean.setPincode(userDetails.getPincode());
				userDetailsBeanList.add(userDetailsBean);
			}

			LOGGER.trace("USER_DETAILS_LIST:: " + userDetailsBeanList);
			if (!sortedUsers.isEmpty()) {
				dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
				dashboardResponse.setResponseData("USER", userDetailsBeanList);
			} else
				errorMsg = "No Records found for requested input.";

		} catch (Exception e) {
			errorMsg = "Following exception occur while fetching User.";
			LOGGER.error(errorMsg + "\n\r : " + e.getStackTrace());
		}
		if (errorMsg != null) {
			dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
			dashboardResponse.setErrorMsg(errorMsg);
		}
		returnValue = MAPPER.writeValueAsString(dashboardResponse);
		LOGGER.trace("Exiting sortByDoj() from UserServiceImpl with return:: returnValue: " + returnValue);
		return returnValue;
	}

}
