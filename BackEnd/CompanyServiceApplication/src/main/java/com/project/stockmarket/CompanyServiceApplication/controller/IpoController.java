package com.project.stockmarket.CompanyServiceApplication.controller;

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


import com.project.stockmarket.CompanyServiceApplication.model.Ipo;
import com.project.stockmarket.CompanyServiceApplication.service.IpoService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("company-service/Ipos")
public class IpoController {
	
	@Autowired
	private IpoService ipoService;
	
	@GetMapping("/")
	public ResponseEntity<List<Ipo>> getAllIpo(){
		
		List<Ipo> ipo = ipoService.getAllIpos();
		return new ResponseEntity<List<Ipo>>(ipo, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ipo> getIpoById(@PathVariable("id") Long id){
		Ipo ipo = ipoService.getIpoById(id);
		return new ResponseEntity<Ipo>(ipo, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Ipo> saveIpo(@RequestBody Ipo ipo){
		
		Ipo newIpo = ipoService.addCompany(ipo);
		return new ResponseEntity<Ipo>(newIpo, HttpStatus.OK);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Ipo> updateIpo(@PathVariable("id") Long id, @RequestBody Ipo ipo){
		
		Ipo updateIpo = ipoService.updateIpo(id, ipo);
		return new ResponseEntity<Ipo>(updateIpo, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteIpo(@PathVariable("id") Long id){
		boolean isDeleted = ipoService.deleteIpo(id);
		if(isDeleted){
			String responseContent = "Book has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting book from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
