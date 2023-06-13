package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.model.DispenserModel;
@Repository
public interface DispenserRepository extends JpaRepository<DispenserModel, Integer> {

	public DispenserModel findByDispenserId(Integer dispenserId);

}
