package com.project.stockmarket.sectorserviceapplication.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarket.sectorserviceapplication.entity.Company;
import com.project.stockmarket.sectorserviceapplication.entity.Sector;
import com.project.stockmarket.sectorserviceapplication.repository.SectorRepository;



@Service
public class SectorService {
	
	@Autowired
	private SectorRepository repository;
	
	public List<Sector> getAllSectors() {
		return repository.findAll();
	}
	
	public Sector getSectorById(int id) {
		Optional<Sector> sectorOptional = repository.findById(id);
		if(sectorOptional.isPresent()) {
			return sectorOptional.get();
		}
		return null;
	}
	
	public Sector createSector(Sector sector) {
		return repository.save(sector);
	}
	
	public List<Company> getCompaniesBySector(int id) {
		Optional<Sector> sector = repository.findById(id);
		if(sector.isPresent()) {
			return sector.get().getCompanies();
		}
		return null;
	}

	public Company updateCompany(int id, Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteCompany(int id) {
		try
		{
		repository.deleteById(id);
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
	
}