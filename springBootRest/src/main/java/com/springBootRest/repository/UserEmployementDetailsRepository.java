package com.springBootRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootRest.model.UserEmployementDetails;

@Repository
public interface UserEmployementDetailsRepository extends JpaRepository<UserEmployementDetails, Integer> {

}