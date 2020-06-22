package com.springBootRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootRest.model.UserMaster;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Integer> {

	UserMaster findUserByUserName(String userName);
}
