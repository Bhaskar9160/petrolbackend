package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.model.PriceModel;
@Repository
public interface PriceRepository extends JpaRepository<PriceModel, Integer>{

	public PriceModel findByPriceId(Integer priceId);

}
