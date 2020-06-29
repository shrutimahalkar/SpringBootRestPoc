package com.springBootRest.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBootRest.common.DashboardResponse;
import com.springBootRest.common.UserManagmentBean;
import com.springBootRest.common.UserMasterBean;

public class ValidationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationService.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public String validDetails(String dashboardRequest) throws Exception {
		LOGGER.trace("Starting validDetails() from ValidationServiceImpl with arguments:: dashboardRequest: "
				+ dashboardRequest);
		String returnValue = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		UserManagmentBean userManagmentBean = MAPPER.readValue(dashboardRequest, UserManagmentBean.class);
		Set<ConstraintViolation<UserManagmentBean>> violations = validator.validate(userManagmentBean);
		for (ConstraintViolation<UserManagmentBean> violation : violations) {
			LOGGER.error(violation.getMessage());
			dashboardResponse.setResponseData(violation.getPropertyPath().toString(), violation.getMessage());
			returnValue = MAPPER.writeValueAsString(dashboardResponse);
			return returnValue;
		}
		return "valid";

	}
	
	public String validMaster(String dashboardRequest) throws Exception {
		LOGGER.trace("Starting getUserValid() from ValidationServiceImpl with arguments:: dashboardRequest: "
				+ dashboardRequest);
		String returnValue = null;
		DashboardResponse dashboardResponse = new DashboardResponse();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		UserMasterBean userMasterBean = MAPPER.readValue(dashboardRequest, UserMasterBean.class);
		Set<ConstraintViolation<UserMasterBean>> violations = validator.validate(userMasterBean);
		for (ConstraintViolation<UserMasterBean> violation : violations) {
			LOGGER.error(violation.getMessage());
			dashboardResponse.setResponseData(violation.getPropertyPath().toString(), violation.getMessage());
			returnValue = MAPPER.writeValueAsString(dashboardResponse);
			return returnValue;
		}
		return "valid";

	}

}
