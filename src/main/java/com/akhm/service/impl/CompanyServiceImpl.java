package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.exception.PetrolProjectException;
import com.akhm.repository.CompanyRepository;
import com.akhm.repository.model.CompanyModel;
import com.akhm.service.CompanyService;

@Service
public class CompanyServiceImpl  implements CompanyService{
	@Autowired
	private CompanyRepository companyRepo;
	@Override
	public CompanyModel insertCompany(CompanyModel companyModel) {
		CompanyModel companyModel2=null;
		companyModel2=companyRepo.save(companyModel);
		return companyModel2;
	}

	@Override
	public List<CompanyModel> getAllCompanies() {
		List<CompanyModel> companyModels=null;
		try {
			
			companyModels=companyRepo.findAll();
		} catch (Exception e) {
			
			throw new PetrolProjectException(e.getMessage());
		}
		return companyModels;

	}

	@Override
	public CompanyModel getCompany(String companyContactEmailId,String password) {
		CompanyModel companyModel=null;
		try {
			companyModel=companyRepo.findByCompanyContactEmailIdAndPassword(companyContactEmailId,password);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
		return companyModel;

	}

	@Override
	public void updateCompany(CompanyModel companyModel) {
		try {
			companyRepo.save(companyModel);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}

		
	}

	@Override
	public void deleteCompany(Integer companyId) {
		
			try {
				companyRepo.deleteById(companyId);
			} catch (Exception e) {
				throw new PetrolProjectException(e.getMessage());
			}
		

	}

	@Override
	public CompanyModel getCompany(Integer companyId) {
		CompanyModel companyModel=null;
		try {
			companyModel=companyRepo.findByCompanyId(companyId);
		} catch (Exception e) {
			throw new PetrolProjectException(e.getMessage());
		}
		return companyModel;

	}

}
