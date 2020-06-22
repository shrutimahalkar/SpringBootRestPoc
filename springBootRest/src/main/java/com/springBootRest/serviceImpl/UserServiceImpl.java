package com.springBootRest.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBootRest.model.CommanConstant;
import com.springBootRest.model.DashboardResponse;
import com.springBootRest.model.UserDetails;
import com.springBootRest.model.UserMaster;
import com.springBootRest.repository.UserDetailsRepository;
import com.springBootRest.repository.UserMasterRepository;
import com.springBootRest.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    @Autowired
    private UserMasterRepository userMasterRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;


    @Override
    public String getUserByFirstNameAndLastName(String dashboardRequest) throws Exception {
        LOGGER.trace("Starting getUserByFirstNameAndLastName() from UserServiceImpl with arguments:: dashboardRequest: "+dashboardRequest);
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {
            JsonNode requestJsonNode = MAPPER.readTree(dashboardRequest);
            String firstName = requestJsonNode.get("firstName").asText();
            String lastName = requestJsonNode.get("lastName").asText();

            UserDetails userDetails = this.userDetailsRepository.findUserByFirstNameAndLastName(firstName, lastName);
            if(userDetails != null) {
                dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
                dashboardResponse.setResponseData("USER", userDetails);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+e.getStackTrace());
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting getUserByFirstNameAndLastName() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }

    @Override
    public String getAllUsers() throws Exception {
        LOGGER.trace("Starting getAllUsers() from UserServiceImpl");
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {

            List<UserMaster> userDetailsList = this.userMasterRepository.findAll();
            LOGGER.trace("USER_DETAILS_LIST:: "+userDetailsList);
            if(!userDetailsList.isEmpty()) {
                dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
                dashboardResponse.setResponseData("USER", userDetailsList);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+e.getStackTrace());
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting getAllUsers() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }

    @Override
    public String getAllActiveUsers() throws Exception {
        LOGGER.trace("Starting getAllActiveUsers() from UserServiceImpl");
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {

            List<UserDetails> activeUserDetailsList = this.userDetailsRepository.findAll();
            LOGGER.trace("ACTIVE_USER_DETAILS_LIST:: "+activeUserDetailsList);
            if(!activeUserDetailsList.isEmpty()) {
                dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
                dashboardResponse.setResponseData("User", activeUserDetailsList);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+e.getStackTrace());
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting getAllActiveUsers() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }

	@Override
	public String createUser(String dashboardRequest) throws Exception {
		 LOGGER.trace("Starting createUser() from UserServiceImpl with arguments:: dashboardRequest: "+dashboardRequest);
	        String returnValue = null;
	        String errorMsg = null;
	        DashboardResponse dashboardResponse = new DashboardResponse();
	        try {
	            JsonNode requestJsonNode = MAPPER.readTree(dashboardRequest);
	            String userName = requestJsonNode.get("userName").asText();
	            String password = requestJsonNode.get("password").asText();
	            UserMaster userMaster=new UserMaster();
	            userMaster.setUserName(userName);
	            userMaster.setPassword(password);
	            userMaster.setIsActive(true);
	            
	            userMaster = this.userMasterRepository.save(userMaster);
	            if(userMaster != null) {
	                dashboardResponse.setStatusCode(CommanConstant.SUCCESS_STATUS);
	                dashboardResponse.setResponseData("USER", userMaster);
	            } else
	                errorMsg = "No Records found.";

	        } catch (Exception e) {
	            errorMsg = "Following exception occur while fetching User Details.";
	            LOGGER.error(errorMsg + "\n\r : "+e.getStackTrace());
	        }
	        if(errorMsg != null){
	            dashboardResponse.setStatusCode(CommanConstant.FAIL_STATUS);
	            dashboardResponse.setErrorMsg(errorMsg);
	        }
	        returnValue = MAPPER.writeValueAsString(dashboardResponse);
	        LOGGER.trace("Exiting createUser() from UserServiceImpl with return:: returnValue: "+returnValue);
	        return returnValue;
	    }
}
