package com.akhm.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "COMPANY_TL")
public class CompanyModel {
	@Id
	@GeneratedValue
	@Column(name = "COMPANY_ID")
	private Integer companyId;
	@Column(name = "COMPANY_NAME")
	private String companyName;
	@Column(name = "COMPANY_ADDRESS")
	private String companyAddress;
	@Column(name = "COMPANY_CONTACT_PERSON_NAME")
	private String companyContactPersonName;
	@Column(name = "COMPANY_CONTACT_EMAIL")
	private String companyContactEmailId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "COMPANY_CREATED_BY")
	private String companyCreatedBy;
	@Column(name = "COMPANY_CREATED_ON")
	private String companyCreatedOn;
	@Column(name = "COMPANY_UPDATED_BY")
	private String companyUpdatedBy;
	@Column(name = "COMPANY_UPDATED_ON")
	private String companyUpdatedOn;

}
