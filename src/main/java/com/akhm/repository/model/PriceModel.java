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
@Table(name = "Price_tl")
public class PriceModel {
	@Id
	@GeneratedValue
	@Column(name = "PRICE_ID")
	private Integer priceId;
	@Column(name = "FUEL_TYPE")
	private String fuelType;
	@Column(name = "PRICE")
	private Integer price;
	@Column(name = "PRICE_CREATED_BY")
	private String priceCreatedBy;
	@Column(name = "PRICE_CREATED_ON")
	private Date priceCreatedOn;
	@Column(name = "PRICE_UPDATED_BY")
	private String priceUpdatedBy;
	@Column(name = "PRICE_UPDATED_ON")
	private Date priceUpdatedOn;
	@Column(name = "STATUS")
	private String status;


}
