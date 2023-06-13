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
@Table(name = "TANK_TL")
public class TankModel {
	@Id
	@GeneratedValue
	@Column(name="TANK_ID")
	private Integer tankId;
	@Column(name="TANK_NAME")
	private Integer tankName;
	@Column(name="station_ID")
	private Integer stationId;
	@Column(name="TANK_CODE")
	private String tankCode;
	@Column(name="TANK_CAPACITY")
	private Double tankCapacity;
	@Column(name="FUEL_TYPE")
	private String fuelType;
	@Column(name="HEIGHT")
	private Integer height;
	@Column(name="CRITICAL_HEIGHT_PRODUCT_ALARM")
	private Integer criticalHeightProductAlarm;
	@Column(name="HIGH_PRODUCT_ALARM")
	private Integer highProductAlarm;
	@Column(name="CRITICAL_LOW_PRODUCT_ALARM")
	private Integer criticalLowProductAlarm;
	@Column(name="LOW_PRODUCT_ALARM")
	private Integer lowProductAlarm;
	@Column(name="HIGH_WATER_ALARM")
	private Integer highWaterAlarm;
	@Column(name="TANK_LEVEL")
	private Integer tankLevel;
	@Column(name = "TANK_CREATED_BY")
	private String tankCreatedBy;
	@Column(name = "TANK_CREATED_ON")
	private Date tankCreatedOn;
	@Column(name = "TANK_UPDATED_BY")
	private String tankUpdatedBy;
	@Column(name = "TANK_UPDATED_ON")
	private Date tankUpdatedOn;
	@Column(name = "STATUS")
	private String status;

	

}
