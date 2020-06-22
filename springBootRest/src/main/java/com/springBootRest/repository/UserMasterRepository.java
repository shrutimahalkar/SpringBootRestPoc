package com.springBootRest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springBootRest.entities.UserMaster;

@Repository
public interface UserMasterRepository extends CrudRepository<UserMaster, Integer> {

}
