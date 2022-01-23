package com.project.stockmarket.StockExchange.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarket.StockExchange.Entity.Company;
import com.project.stockmarket.StockExchange.Entity.StockExchange;
import com.project.stockmarket.StockExchange.Repository.StockExchangeRepository;
import com.project.stockmarket.StockExchange.Service.StockExchangeService;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	private StockExchangeRepository stockExchangeRepository;
	
	
	public List<StockExchange> getAllStockExchange() {
		List<StockExchange> stockExchanges = stockExchangeRepository.findAll();
		return stockExchanges;
	}

	public StockExchange findById(Long id) {
		Optional<StockExchange> stockExchange = stockExchangeRepository.findById(id);
		if(!stockExchange.isPresent())
			return null;
		return stockExchange.get();
	}

	public StockExchange addStockExchange(StockExchange stockExchange) {
		stockExchange = stockExchangeRepository.save(stockExchange);
		return stockExchange;	
	}

	public StockExchange editStockExchange(StockExchange stockExchange) {
		if(findById(stockExchange.getId()) == null)
			return null;
		stockExchange = stockExchangeRepository.save(stockExchange);
		return stockExchange;
	}

	public void deleteStockExchange(Long id) {
		stockExchangeRepository.deleteById(id);
		
	}

	public List<Company> getCompanies(Long id) {
		Optional<StockExchange> stockExchange = stockExchangeRepository.findById(id);
		if(!stockExchange.isPresent())
			return null;
		return stockExchange.get().getCompanies();
	}

}
