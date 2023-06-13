package com.akhm.service;

import java.util.List;

import com.akhm.repository.model.StationModel;

public interface StationService {
	public StationModel insertStation(StationModel stationModel);
	public List<StationModel> getAllStations();
	public void updateStation(StationModel stationModel);
	public void deleteStation(Integer stationId);
	public StationModel getStation(Integer stationId); 


}
