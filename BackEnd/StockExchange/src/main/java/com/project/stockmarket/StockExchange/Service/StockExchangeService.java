package com.project.stockmarket.StockExchange.Service;

import java.util.List;

import com.project.stockmarket.StockExchange.Entity.Company;
import com.project.stockmarket.StockExchange.Entity.StockExchange;

public interface StockExchangeService {

	public List<StockExchange> getAllStockExchange();
	public StockExchange findById(Long id);
	public StockExchange addStockExchange(StockExchange stockExchange);
	public StockExchange editStockExchange(StockExchange stockExchange);
	public void deleteStockExchange(Long id);
	public List<Company> getCompanies(Long id);
}
