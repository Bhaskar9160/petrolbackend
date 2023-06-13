package com.akhm.service;

import java.util.List;

import com.akhm.repository.model.PriceModel;

public interface PriceService {
	public PriceModel insertPrice(PriceModel priceModel);
	public List<PriceModel> getAllPrices();
	public void updatePrice(PriceModel priceModel);
	public PriceModel getPrice(Integer priceId); 


}
