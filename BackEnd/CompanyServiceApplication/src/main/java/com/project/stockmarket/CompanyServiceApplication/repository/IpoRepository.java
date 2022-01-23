package com.project.stockmarket.CompanyServiceApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarket.CompanyServiceApplication.model.Company;
import com.project.stockmarket.CompanyServiceApplication.model.Ipo;

@Repository
public interface IpoRepository extends JpaRepository<Ipo,Long> {
	
	

}
