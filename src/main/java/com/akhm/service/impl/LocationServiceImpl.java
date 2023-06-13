package com.akhm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akhm.exception.PetrolProjectException;
import com.akhm.repository.LocationRepository;
import com.akhm.repository.model.LocationModel;
import com.akhm.service.LocationService;
@Service
public class LocationServiceImpl implements LocationService{

	private LocationRepository locationRepo;
	@Override
	public LocationModel insertLocation(LocationModel locationModel) {
		LocationModel locationModel2=null;
		locationModel2=locationRepo.save(locationModel);
		return locationModel2;	
		}

	@Override
	public List<LocationModel> getAllLocations() {
		List<LocationModel> locationModels=null;
		try {
			
			locationModels=locationRepo.findAll();
		} catch (Exception e) {
			
			throw new PetrolProjectException(e.getMessage());
		}
		return locationModels;

	}

	@Override
	public void updateLocation(LocationModel locationModel) {
		try {
			locationRepo.save(locationModel);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
	}

	@Override
	public void deleteLocation(Integer locationId) {
		try {
			locationRepo.deleteById(locationId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
	
	}

	@Override
	public LocationModel getLocation(Integer locationId) {
		LocationModel locationModel=null;
		try {
			locationModel=locationRepo.findByLocationId(locationId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
		return locationModel;

	}

}
