package com.project.stockmarket.CompanyServiceApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Ipo 
{
	@Id
    @GeneratedValue
	private Long id;
	private String companyName;
	private String stockExchangeName;
	private double price;
	private int shares;
	private String openDateTime;
	private String remarks;
	
	
	@ManyToOne
	private Company company;

	public Ipo(Long id, String companyName, String stockExchangeName, double price, int shares, String openDateTime,
			String remarks) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.stockExchangeName = stockExchangeName;
		this.price = price;
		this.shares = shares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
	}

	public Ipo(Long id, String companyName, String stockExchangeName, double price, int shares, String openDateTime,
			String remarks, Company company) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.stockExchangeName = stockExchangeName;
		this.price = price;
		this.shares = shares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
		this.company = company;
	}

	public Ipo() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public String getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(String openDateTime) {
		this.openDateTime = openDateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
