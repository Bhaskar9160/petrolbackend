package com.akhm.repository.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="LOCATION_TL")
public class LocationModel {
	@Id
	@GeneratedValue
	@Column(name = "LOCATION_ID")
	private Integer locationId;
	@Column(name = "LOCATION_NAME")
	private String locationName;
	@Column(name = "LOCATION_ADDRESS")
	private String locationAddress;
	@Column(name = "LOCATION_CREATED_BY")
	private String locationCreatedBy;
	@Column(name = "LOCATION_CREATED_ON")
	private Date locationCreatedOn;
	@Column(name = "LOCATION_UPDATED_BY")
	private String locationUpdatedBy;
	@Column(name = "LOCATION_UPDATED_ON")
	private Date locationUpdatedOn;
	@Column(name = "STATUS")
	private String status;

	

}
