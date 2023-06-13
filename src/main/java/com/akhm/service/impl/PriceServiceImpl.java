package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.exception.PetrolProjectException;
import com.akhm.repository.PriceRepository;
import com.akhm.repository.model.PriceModel;
import com.akhm.service.PriceService;
@Service
public class PriceServiceImpl implements PriceService{

	@Autowired
	private PriceRepository priceRepo;
	@Override
	public PriceModel insertPrice(PriceModel priceModel) {
		PriceModel priceModel2=null;
		priceModel2=priceRepo.save(priceModel);
		return priceModel2;	
	}

	@Override
	public List<PriceModel> getAllPrices() {
		List<PriceModel> priceModels=null;
		try {
			
			priceModels=priceRepo.findAll();
		} catch (Exception e) {
			
			throw new PetrolProjectException(e.getMessage());
		}
		return priceModels;
	}

	@Override
	public void updatePrice(PriceModel priceModel) {
		try {
			priceRepo.save(priceModel);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
	}

	@Override
	public PriceModel getPrice(Integer priceId) {
		PriceModel priceModel=null;
		try {
			priceModel=priceRepo.findByPriceId(priceId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
		return priceModel;
	}

}
