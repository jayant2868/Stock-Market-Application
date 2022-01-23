package com.project.stockmarket.sectorserviceapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarket.sectorserviceapplication.entity.Company;
import com.project.stockmarket.sectorserviceapplication.entity.Sector;
import com.project.stockmarket.sectorserviceapplication.service.SectorService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("sector-service/sectors")
public class SectorController {

	@Autowired
	private SectorService sectorService;
	
	@GetMapping("/")
	public ResponseEntity<List<Sector>> getAllSectors(){
		return ResponseEntity.ok(sectorService.getAllSectors());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getSectorById(@PathVariable(value = "id") int id){
		Sector sector = sectorService.getSectorById(id);
		if(sector != null)
			return ResponseEntity.ok(sector);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Sector found for the given Id");
	}
	
	@PostMapping("/add")
	public ResponseEntity<Sector> createSector(@RequestBody Sector sector){
		return ResponseEntity.ok(sectorService.createSector(sector));
	}
	
	@GetMapping("/companies/{id}")
	public ResponseEntity<List<Company>> getAllCompaniesBySector(@PathVariable(value = "id") int id){
		return ResponseEntity.ok(sectorService.getCompaniesBySector(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") int id, @RequestBody Company company){
		
		Company updateCompany = sectorService.updateCompany(id, company);
		return new ResponseEntity<Company>(updateCompany, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") int id){
		boolean isDeleted = sectorService.deleteCompany(id);
		if(isDeleted){
			String responseContent = "Company has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Company from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
