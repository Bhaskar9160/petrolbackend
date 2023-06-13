package com.akhm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akhm.exception.PetrolProjectException;
import com.akhm.repository.TankRepository;
import com.akhm.repository.model.TankModel;
import com.akhm.service.TankService;
@Service
public class TankServiceImpl implements TankService{

	private TankRepository tankRepo;
	@Override
	public TankModel insertTank(TankModel tankModel) {
		TankModel tankModel2=null;
		tankModel2=tankRepo.save(tankModel);
		return tankModel2;
	}

	@Override
	public List<TankModel> getAllTanks() {
		List<TankModel> tankModels=null;
		try {
			
			tankModels=tankRepo.findAll();
		} catch (Exception e) {
			
			throw new PetrolProjectException(e.getMessage());
		}
		return tankModels;

	}

	@Override
	public void updateTank(TankModel tankModel) {
		try {
			tankRepo.save(tankModel);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
	}

	@Override
	public void deleteTank(Integer tankId) {
		try {
			tankRepo.deleteById(tankId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}

	}

	@Override
	public TankModel getTank(Integer tankId) {
		TankModel tankModel=null;
		try {
			tankModel=tankRepo.findByTankId(tankId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
		return tankModel;
	}

}
