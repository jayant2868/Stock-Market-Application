package com.project.stockmarket.StockPriceApplication.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockPrice 
{
	@Id
	private String id;
	private String companyCode;
	private String stockExchangeName;
	private double price;
	private String date;
	private String time;
	
	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockPrice(String id, String companyCode, String stockExchangeName, double price, String date, String time) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.price = price;
		this.date = date;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	
}
