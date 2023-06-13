package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.model.StationModel;
@Repository
public interface StationRepository extends JpaRepository<StationModel, Integer>{

	public StationModel findByStationId(Integer stationId);

}
