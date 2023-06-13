package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.model.CompanyModel;
@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Integer>{

	public CompanyModel findByCompanyContactEmailIdAndPassword(String companyContactEmailId, String password);

	public CompanyModel findByCompanyId(Integer companyId);

}
