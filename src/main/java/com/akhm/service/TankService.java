package com.akhm.service;

import java.util.List;

import com.akhm.repository.model.TankModel;


public interface TankService {
	public TankModel insertTank(TankModel tankModel);
	public List<TankModel> getAllTanks();
	public void updateTank(TankModel tankModel);
	public void deleteTank(Integer tankId);
	public TankModel getTank(Integer tankId); 


}
