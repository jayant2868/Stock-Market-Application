package com.project.stockmarket.StockPriceApplication.Controller;

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

import com.project.stockmarket.StockPriceApplication.Entity.StockPrice;
import com.project.stockmarket.StockPriceApplication.Service.StockPriceService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/stock-price-service/stockPrices")
public class StockPriceController 
{
	@Autowired
	private StockPriceService stockPriceService;
	
	@GetMapping("/")
	public ResponseEntity<List<StockPrice>> findAll() {
		List<StockPrice> stockprices = stockPriceService.findAll();
		return new ResponseEntity<List<StockPrice>>(stockprices,HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<StockPrice> findById(@PathVariable String id)
			
	{
		StockPrice stockPrice = stockPriceService.findById(id);
		if(stockPrice == null) {
			return new ResponseEntity<StockPrice>(stockPrice,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StockPrice>(stockPrice,HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<StockPrice> addStockPrice(@RequestBody StockPrice stockPrice) {
		StockPrice newStockPrice = stockPriceService.addStockPrice(stockPrice);
		return new ResponseEntity<StockPrice>(newStockPrice,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<StockPrice> update(@RequestBody StockPrice stockPrice)
			
	{
		StockPrice updatedStockPrice = stockPriceService.update(stockPrice);
		if(updatedStockPrice == null) {
			return new ResponseEntity<StockPrice>(updatedStockPrice,HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(updatedStockPrice);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable String id) {
		stockPriceService.deleteById(id);
	}
}
