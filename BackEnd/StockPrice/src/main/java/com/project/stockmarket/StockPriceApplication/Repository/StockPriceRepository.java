package com.project.stockmarket.StockPriceApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stockmarket.StockPriceApplication.Entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice,String> {

}
