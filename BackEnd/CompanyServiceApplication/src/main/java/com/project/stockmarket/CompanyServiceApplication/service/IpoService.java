package com.project.stockmarket.CompanyServiceApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarket.CompanyServiceApplication.model.Company;
import com.project.stockmarket.CompanyServiceApplication.model.Ipo;
import com.project.stockmarket.CompanyServiceApplication.repository.IpoRepository;

@Service
public class IpoService {
	
	@Autowired
	private IpoRepository ipoRepository;

	public List<Ipo> getAllIpos() {
		List<Ipo> ipo= ipoRepository.findAll();
		 return ipo;
	}

	public Ipo getIpoById(Long id) {
		Optional<Ipo> ipo = ipoRepository.findById(id);
		if(!ipo.isPresent())
			return null;
		return ipo.get();
	}

	public Ipo addCompany(Ipo ipo) {
		Ipo addIpo = ipoRepository.save(ipo);
		return addIpo;
	}

	public Ipo updateIpo(Long id, Ipo ipo) {
		Optional<Ipo> optionalIpo = ipoRepository.findById(id);
		if(optionalIpo == null)
			return null;
		Ipo updateIpo= optionalIpo.get();
		updateIpo = ipoRepository.save(ipo);
		return updateIpo;
	}

	public boolean deleteIpo(Long id) {
		try
		{
		ipoRepository.deleteById(id);
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
