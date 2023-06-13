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
@Table(name="STATION_TL")
public class StationModel {
	@Id
	@GeneratedValue
	@Column(name = "STATION_ID")
	private Integer stationId;
	@Column(name = "LOCATION_ID")
	private Integer locationId;
	@Column(name = "STATION_NAME")
	private String stationName;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "OPENING_TIME")
	private String openingTime;
	@Column(name = "CLOSING_TIME")
	private String closingTime;
	@Column(name = "STATION_CREATED_BY")
	private String stationCreatedBy;
	@Column(name = "STATION_CREATED_ON")
	private Date stationCreatedOn;
	@Column(name = "STATION_UPDATED_BY")
	private String stationUpdatedBy;
	@Column(name = "STATION_UPDATED_ON")
	private Date stationUpdatedOn;
	@Column(name = "STATUS")
	private String status;


}
