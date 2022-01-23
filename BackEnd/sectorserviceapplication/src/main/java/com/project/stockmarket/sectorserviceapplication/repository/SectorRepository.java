package com.project.stockmarket.sectorserviceapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.stockmarket.sectorserviceapplication.entity.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Integer>{

	public Optional<Sector> findById(String id);
}

