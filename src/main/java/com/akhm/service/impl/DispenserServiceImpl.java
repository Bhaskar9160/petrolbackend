package com.akhm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akhm.exception.PetrolProjectException;
import com.akhm.repository.DispenserRepository;
import com.akhm.repository.model.DispenserModel;
import com.akhm.service.DispenserService;
@Service
public class DispenserServiceImpl implements DispenserService{

	private DispenserRepository dispenserRepo;
	@Override
	public DispenserModel insertDispenser(DispenserModel dispenserModel) {
		DispenserModel dispenserModel2=null;
		dispenserModel2=dispenserRepo.save(dispenserModel);
		return dispenserModel2;
	}

	@Override
	public List<DispenserModel> getAllDispensers() {
		List<DispenserModel> dispenserModels=null;
		try {
			
			dispenserModels=dispenserRepo.findAll();
		} catch (Exception e) {
			
			throw new PetrolProjectException(e.getMessage());
		}
		return dispenserModels;

	}

	@Override
	public void updateDispenser(DispenserModel dispenserModel) {
		try {
			dispenserRepo.save(dispenserModel);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}

	}

	@Override
	public void deleteDispenser(Integer dispenserId) {
		try {
			dispenserRepo.deleteById(dispenserId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
	
	}

	@Override
	public DispenserModel getDispenser(Integer dispenserId) {
		DispenserModel dispenserModel=null;
		try {
			dispenserModel=dispenserRepo.findByDispenserId(dispenserId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
		return dispenserModel;

	}

}
