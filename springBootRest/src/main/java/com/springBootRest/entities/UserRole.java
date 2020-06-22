package com.springBootRest.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class UserRole {
	
	@Id
	@GeneratedValue
	private int roleId;

	@Column(name = "roleName")
	private String roleName;

	@Column(name = "roleDesc")
	private String roleDesc;

	@Column(name = "createDate", updatable = false)
	@CreationTimestamp
	private Date CreateDate;

	@Column(name = "updateDate")
	@UpdateTimestamp
	private Date updateDate;


}
