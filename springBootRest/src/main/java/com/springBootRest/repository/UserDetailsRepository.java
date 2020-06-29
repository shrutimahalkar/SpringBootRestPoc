package com.springBootRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springBootRest.model.UserDetails;
import com.springBootRest.model.UserMaster;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    //UserDetails findUserByFirstNameAndLastName(String firstName, String lastName);

	List<UserDetails> findByFirstNameOrLastNameOrPincode(String fName, String lName, String pin);

	@Query("select e from UserDetails e order by dateOfBirth")
    List<UserDetails> sortByDob();
	
	@Query("select e from UserDetails e order by dateOfJoining")
    List<UserDetails> sortByDoj();


	UserDetails findByUserId(int id);

	UserDetails findByUserMaster(UserMaster userMaster);



}