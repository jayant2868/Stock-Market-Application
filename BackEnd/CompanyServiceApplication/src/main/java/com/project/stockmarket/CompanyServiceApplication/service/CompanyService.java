package com.project.stockmarket.CompanyServiceApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarket.CompanyServiceApplication.controller.CompanyController;
import com.project.stockmarket.CompanyServiceApplication.model.Company;
import com.project.stockmarket.CompanyServiceApplication.model.Ipo;
import com.project.stockmarket.CompanyServiceApplication.model.StockPrices;
import com.project.stockmarket.CompanyServiceApplication.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> getCompanies() {
		List<Company> company= companyRepository.findAll();
			 return company;
	}

	public Company getCompanyById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		if(!company.isPresent())
			return null;
		return company.get();
	}

	public Company addCompany(Company company) {
		Company addcompany = companyRepository.save(company);
		
		return addcompany;
	}


	public Company updateCompany(Long id, Company company) {
		Optional<Company> optionalCompany = companyRepository.findById(id);
		if(optionalCompany == null)
			return null;
		Company updateCompany= optionalCompany.get();
		updateCompany = companyRepository.save(company);
		return updateCompany;
	}

	public boolean deleteCompany(Long id) {
		try
		{
		companyRepository.deleteById(id);
		return true;
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			return false;
		}
	}

	public List<Company> getCompaniesByPattern(String pattern) {
		List<Company> companies = companyRepository.findByNameIgnoreCaseContaining(pattern);
		return companies;
	}

	public List<Ipo> getCompanyIpoDetails(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		if(company.isPresent()==false)
			return null;
		return company.get().getIpos();
				
	}

	public List<StockPrices> getStockPrices(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		if(!company.isPresent())
			return null;
		return company.get().getStockPrices();
	}

	public Company addIpoToCompany(String companyName, Ipo ipo) {
		Company company = companyRepository.findByName(companyName);
		if(company == null)
			return null;
		company.getIpos().add(ipo);
		company = companyRepository.save(company);
		return company;
	}

	public Company addStockPriceToCompany(String companyCode, StockPrices stockPrices) {
		Company company = companyRepository.findByCode(companyCode);
		if(company == null)
			return null;
		company.getStockPrices().add(stockPrices);
		company = companyRepository.save(company);
		return company;
	}

}

