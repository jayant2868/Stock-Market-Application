package com.project.stockmarket.CompanyServiceApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.project.stockmarket.CompanyServiceApplication.service.CompanyService;

import com.project.stockmarket.CompanyServiceApplication.model.Company;
import com.project.stockmarket.CompanyServiceApplication.model.Ipo;
import com.project.stockmarket.CompanyServiceApplication.model.StockPrices;
@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("company-service/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/")
	public ResponseEntity<List<Company>> getAllCompany(){
		
		List<Company> company = companyService.getCompanies();
		return new ResponseEntity<List<Company>>(company, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id){
		Company company = companyService.getCompanyById(id);
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	
	@GetMapping("/match/{pattern}")
	public ResponseEntity<List<Company>> getCompaniesByPattern(@PathVariable("pattern") String pattern)
	{
		List<Company> company = companyService.getCompaniesByPattern(pattern);
		return new ResponseEntity<List<Company>>(company,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Company> createCompany(@RequestBody Company company){
		
		Company newcompany = companyService.addCompany(company);
		return new ResponseEntity<Company>(newcompany, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company){
		
		Company updateCompany = companyService.updateCompany(id, company);
		return new ResponseEntity<Company>(updateCompany, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id){
		boolean isDeleted = companyService.deleteCompany(id);
		if(isDeleted){
			String responseContent = "Company has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Company from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/{id}/ipos")
	public ResponseEntity<List<Ipo>> getCompanyIpoDetails(@PathVariable Long id)
		
	{
		List<Ipo> ipo = companyService.getCompanyIpoDetails(id);
		
		return new ResponseEntity<List<Ipo>>(ipo, HttpStatus.OK);
	}
	@GetMapping("/{id}/stockPrices")
	public ResponseEntity<List<StockPrices>> getStockPrices(@PathVariable Long id)
			
	{
		List<StockPrices> stockPrices= companyService.getStockPrices(id);
		
		return new ResponseEntity<List<StockPrices>>(stockPrices, HttpStatus.OK);
	}
	@PostMapping(path = "/{companyName}/ipos")
	public void addIpoToCompany(@PathVariable String companyName, @RequestBody Ipo ipo)
		
	{
		Company company = companyService.addIpoToCompany(companyName, ipo);
		
	}
	
	@PostMapping(path = "/{companyCode}/stockPrices")
	public void addStockPriceToCompany(@PathVariable String companyCode, @RequestBody StockPrices stockPrices) 
			
	{
		Company company = companyService.addStockPriceToCompany(companyCode, stockPrices);
		
	}

}

