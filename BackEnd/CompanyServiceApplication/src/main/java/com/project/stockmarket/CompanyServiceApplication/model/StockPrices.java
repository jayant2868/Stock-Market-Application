package com.project.stockmarket.CompanyServiceApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class StockPrices
{
	@Id
	@GeneratedValue
	private String id;
	
	private String companyCode;
	private String stockExchangeName;
	private double price;
	private String date;
	private String time;

	@ManyToOne
	private Company company;

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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public StockPrices(String id, String companyCode, String stockExchangeName, double price, String date, String time,
			Company company) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.price = price;
		this.date = date;
		this.time = time;
		this.company = company;
	}

	public StockPrices(String id, String companyCode, String stockExchangeName, double price, String date,
			String time) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.price = price;
		this.date = date;
		this.time = time;
	}

	public StockPrices() {
		
	}
	
	

}