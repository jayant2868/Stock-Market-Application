package com.project.stockmarket.CompanyServiceApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarket.CompanyServiceApplication.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
	
	public Optional<Company> findById(Long id);
	public List<Company> findByNameIgnoreCaseContaining(String pattern);
	public Company findByName(String name);
	public Company findByCode(String code);
	

}
