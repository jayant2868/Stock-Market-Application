package com.project.stockmarket.StockExchange.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String code;
	private String turnover;
	private String ceo;
	private String boardOfDirectors;
	private String stockExchangeNames;
	private String sectorName;
	private String description;
	
	
	
	public Company(Long id, String name, String code, String turnover, String ceo, String boardOfDirectors,
			String stockExchangeNames, String sectorName, String description) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.stockExchangeNames = stockExchangeNames;
		this.sectorName = sectorName;
		this.description = description;
	}
	public Company() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}
	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}
	public String getStockExchangeNames() {
		return stockExchangeNames;
	}
	public void setStockExchangeNames(String stockExchangeNames) {
		this.stockExchangeNames = stockExchangeNames;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
