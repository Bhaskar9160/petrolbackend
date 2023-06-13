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
@Table(name="DISPENSER_TL")
public class DispenserModel {
	@Id
	@GeneratedValue
	@Column(name="DIPENSER_ID")
	private Integer dispenserId;
	@Column(name="DIPENSER_NAME")
	private String dispenserName;
	@Column(name="STATION_ID")
	private Integer stationId;
	@Column(name="DIPENSER_CODE")
	private String dispenserCode;
	@Column(name="FUEL_TYPE")
	private String fuelType;

	@Column(name="DIPENSER_TIME")
	private String dispenserTime;
	@Column(name = "DISPENSER_CREATED_BY")
	private String dispenserCreatedBy;
	@Column(name = "DISPENSER_CREATED_ON")
	private Date dispenserCreatedOn;
	@Column(name = "DISPENSER_UPDATED_BY")
	private String dispenserUpdatedBy;
	@Column(name = "DISPENSER_UPDATED_ON")
	private Date dispenserUpdatedOn;
	@Column(name = "STATUS")
	private String status;

}