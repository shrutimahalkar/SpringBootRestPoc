package com.springBootRest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	
	
	@Column(name ="firstName")
	private String firstName;
	
	@Column(name ="lastName")
	private String lastName;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="dateOfBirth")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Madrid")
	private Date dateOfBirth;
	
	@Column(name="dateOfJoining")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Madrid")
	private Date dateOfJoining;
	
	@Column(name = "is_active")
	private boolean isActive = true;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;
	
	@OneToOne
	@JoinColumn(name="userMasterId")
	private UserMaster userMaster;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}
	
}
