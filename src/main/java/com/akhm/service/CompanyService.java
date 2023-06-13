package com.akhm.service;

import java.util.List;

import com.akhm.repository.model.CompanyModel;

public interface CompanyService {
	public CompanyModel insertCompany(CompanyModel companyModel);
	public List<CompanyModel> getAllCompanies();
	public CompanyModel getCompany(String companyContactEmailId,String password);
	public void updateCompany(CompanyModel companyModel);
	public void deleteCompany(Integer companyId);
	public CompanyModel getCompany(Integer companyId); 

}
