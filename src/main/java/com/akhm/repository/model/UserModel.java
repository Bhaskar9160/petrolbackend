package com.akhm.repository.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_TL")
public class UserModel {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "COMPANY_ID")
	private Integer companyId;
	@Column(name = "USER_CREATED_BY")
	private String userCreatedBy;
	@Column(name = "USER_CREATED_ON")
	private Date userCreatedOn;
	@Column(name = "USER_UPDATED_BY")
	private String userUpdatedBy;
	@Column(name = "USER_UPDATED_ON")
	private Timestamp userUpdatedOn;
	@Column(name = "STATUS")
	private String status;

	

}
