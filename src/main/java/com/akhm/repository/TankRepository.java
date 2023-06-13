package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.model.TankModel;
@Repository
public interface TankRepository extends JpaRepository<TankModel, Integer>{

	public TankModel findByTankId(Integer tankId);

}
