package com.project.stockmarket.StockExchange.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stockmarket.StockExchange.Entity.StockExchange;
public interface StockExchangeRepository extends JpaRepository<StockExchange,Long> {
	
	

}
