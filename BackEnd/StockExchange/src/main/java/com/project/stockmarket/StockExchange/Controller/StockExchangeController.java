package com.project.stockmarket.StockExchange.Controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.*;
import com.project.stockmarket.StockExchange.Service.StockExchangeService;
import com.project.stockmarket.StockExchange.Entity.StockExchange;
import com.project.stockmarket.StockExchange.Entity.Company;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/StockExchange-services")
public class StockExchangeController {
	
	@Autowired
	private StockExchangeService stockExchangeServices;
	
	@GetMapping("/")
	private ResponseEntity<List<StockExchange>> getStockExchanges()
	{
		return new ResponseEntity<List<StockExchange>>(stockExchangeServices.getAllStockExchange(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<StockExchange> getStockExchangeDetails(@PathVariable Long id)
			
	{
		StockExchange stockExchange = stockExchangeServices.findById(id);
		if(stockExchange == null) {
		     return new ResponseEntity<StockExchange>(stockExchange,HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(stockExchange);
	}
	
	@PostMapping("/add")
	public ResponseEntity<StockExchange> addStockExchange(@RequestBody StockExchange stockExchange) {
		return new ResponseEntity<StockExchange>(stockExchangeServices.addStockExchange(stockExchange),HttpStatus.OK);
	}
	
	@PutMapping(path = "")
	public ResponseEntity<StockExchange> editStockExchange(@RequestBody StockExchange stockExchange) 
	{
		StockExchange updatedStockExchange = stockExchangeServices.editStockExchange(stockExchange);
		if(updatedStockExchange == null) {
			return new ResponseEntity<StockExchange>(updatedStockExchange,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StockExchange>(updatedStockExchange,HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	public void deleteStockExchange(@PathVariable Long id) {
		stockExchangeServices.deleteStockExchange(id);
	}
	
	@GetMapping(path = "/{id}/companies")
	public ResponseEntity<List<Company>> getCompanies(@PathVariable Long id)  
	{
		List<Company> company = stockExchangeServices.getCompanies(id);
		if(company == null) {
			return new ResponseEntity<List<Company>>(company,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Company>>(company,HttpStatus.OK);

	}

}
