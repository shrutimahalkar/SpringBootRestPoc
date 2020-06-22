package com.springBootRest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springBootRest.service.UserService;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsers() throws Exception {
        LOGGER.trace("Starting getAllUsers() from UserController");
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.getAllUsers();
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting getAllUsers() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }
    
    @RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting createUser() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.createUser(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting createUser() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }
    
    @RequestMapping(value = "/saveUserdetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUserdetails(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting createUser() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.saveUserdetails(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting saveUserdetails() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

}
