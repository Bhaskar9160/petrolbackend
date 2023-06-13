package com.akhm.service;

import java.util.List;

import com.akhm.repository.model.DispenserModel;

public interface DispenserService {
	public DispenserModel insertDispenser(DispenserModel dispenserModel);
	public List<DispenserModel> getAllDispensers();
	public void updateDispenser(DispenserModel dispenserModel);
	public void deleteDispenser(Integer dispenserId);
	public DispenserModel getDispenser(Integer dispenserId); 


}
