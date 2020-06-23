package com.springBootRest.service;

public interface UserService {

    public String getAllUsers() throws Exception;
    
    public String createUser(String dashboardRequest)throws Exception;
    
    public String saveUserdetails(String dashboardRequest)throws Exception;

	public String searchFnameLnamePin(String dashboardRequest)throws Exception;

	public String editUserDetails(String dashboardRequest)throws Exception;

	public String softDelete(String dashboardRequest)throws Exception;

	public String hardtDelete(String dashboardRequest)throws Exception;
    
    


}
