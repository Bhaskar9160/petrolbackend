package com.akhm.service;

import java.util.List;

import com.akhm.repository.model.LocationModel;

public interface LocationService {
	public LocationModel insertLocation(LocationModel locationModel);
	public List<LocationModel> getAllLocations();
	public void updateLocation(LocationModel locationModel);
	public void deleteLocation(Integer locationId);
	public LocationModel getLocation(Integer locationId); 


}
