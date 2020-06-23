package com.springBootRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootRest.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    //UserDetails findUserByFirstNameAndLastName(String firstName, String lastName);

	List<UserDetails> findByFirstNameOrLastNameOrPincode(String fName, String lName, String pin);

	UserDetails findById(int id);

}