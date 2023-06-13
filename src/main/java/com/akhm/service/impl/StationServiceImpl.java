package com.akhm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akhm.exception.PetrolProjectException;
import com.akhm.repository.StationRepository;
import com.akhm.repository.model.StationModel;
import com.akhm.service.StationService;
@Service											
public class StationServiceImpl implements StationService{

	private StationRepository stationRepo;
	@Override
	public StationModel insertStation(StationModel stationModel) {
		StationModel stationModel2=null;
		stationModel2=stationRepo.save(stationModel);
		return stationModel2;
	}

	@Override
	public List<StationModel> getAllStations() {
		List<StationModel> stationModels=null;
		try {
			
			stationModels=stationRepo.findAll();
		} catch (Exception e) {
			
			throw new PetrolProjectException(e.getMessage());
		}
		return stationModels;

	}

	@Override
	public void updateStation(StationModel stationModel) {
		try {
			stationRepo.save(stationModel);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
	}

	@Override
	public void deleteStation(Integer stationId) {
		try {
			stationRepo.deleteById(stationId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
	}

	@Override
	public StationModel getStation(Integer stationId) {
		StationModel stationModel=null;
		try {
			stationModel=stationRepo.findByStationId(stationId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
		return stationModel;

	}

}
