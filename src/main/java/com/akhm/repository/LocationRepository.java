package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.model.LocationModel;
@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Integer>{

	public LocationModel findByLocationId(Integer locationId);

}
