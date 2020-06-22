package com.springBootRest.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class UserEmployementDetails {
	
	@Id
	@GeneratedValue
	private int empId;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "location")
	private String location;
	
	@Column(name = "dateOfJoining")
	private Date dateOfJoining;
	
	@Column(name = "yearOfExperience")
	private Date yearOfExperience;
	
	
	@Column(name = "isActive")
	private Boolean isActive = true;

	@Column(name = "createDate", updatable = false)
	@CreationTimestamp
	private Date CreateDate;

	@Column(name = "updateDate")
	@UpdateTimestamp
	private Date updateDate;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(Date yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	

}
