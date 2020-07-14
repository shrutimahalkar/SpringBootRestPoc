package com.springBootRest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springBootRest.JWTConfig.JWTutil;
import com.springBootRest.model.AuthRequest;
import com.springBootRest.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
//@RequestMapping("/users")
public class UserController extends ValidationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private JWTutil jWTutil;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @RequestMapping("/")
    public String welcome(){
    	return "welcom shruti";
    }
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception e) {
           // throw new Exception("inavalid username/password");
        }
        return jWTutil.generateToken(authRequest.getUserName());
    }
    
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
        if(validMaster(dashboardRequest).equals("valid")){
        String jsonString = userService.createUser(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else
            responseEntity = ResponseEntity.ok(validMaster(dashboardRequest));
        LOGGER.trace("Exiting createUser() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }
    
    @RequestMapping(value = "/saveUserdetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUserdetails(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting saveUserdetails() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        if(validDetails(dashboardRequest).equals("valid")){
        String jsonString = userService.saveUserdetails(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else
            responseEntity = ResponseEntity.ok(validDetails(dashboardRequest));
        LOGGER.trace("Exiting saveUserdetails() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }
    
    @RequestMapping(value = "/searchFnameLnamePin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchFnameLnamePin(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting searchFnameLnamePin() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.searchFnameLnamePin(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting searchFnameLnamePin() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/editUserDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editUserDetails(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting searchFnameLnamePin() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.editUserDetails(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      
        LOGGER.trace("Exiting saveUserdetails() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/softDelete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> softDelete(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting softDelete() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        if(validMaster(dashboardRequest).equals("valid")){
        String jsonString = userService.softDelete(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else
            responseEntity = ResponseEntity.ok(validMaster(dashboardRequest));
        LOGGER.trace("Exiting softDelete() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }
    
    @RequestMapping(value = "/hardDelete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> hardtDelete(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting hardtDelete() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.hardDelete(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting hardtDelete() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }
    @RequestMapping(value = "/sortByDob", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sortByDob() throws Exception {
        LOGGER.trace("Starting sortByDob() from UserController");
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.sortByDob();
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting sortByDob() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }
    

    @RequestMapping(value = "/sortByDoj", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sortByDoj() throws Exception {
        LOGGER.trace("Starting sortByDob() from UserController");
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.sortByDoj();
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting sortByDoj() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserById(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting getUserById() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.getUserById(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting getUserById() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

}
