package com.project.stockmarket.StockPriceApplication.Service;

import java.util.List;

import com.project.stockmarket.StockPriceApplication.Entity.StockPrice;

public interface StockPriceService {
	
	public List<StockPrice> findAll();
	public StockPrice findById(String id);
	public StockPrice addStockPrice(StockPrice stockPrice);
	public StockPrice update(StockPrice stockPrice);
	public void deleteById(String id);

}
