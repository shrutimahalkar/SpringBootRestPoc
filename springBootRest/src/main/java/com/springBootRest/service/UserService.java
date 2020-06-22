package com.springBootRest.service;

public interface UserService {

    public String getUserByFirstNameAndLastName(String dashboardRequest) throws Exception;

    public String getAllUsers() throws Exception;

    public String getAllActiveUsers() throws Exception;
    
    public String createUser(String dashboardRequest)throws Exception;

}
