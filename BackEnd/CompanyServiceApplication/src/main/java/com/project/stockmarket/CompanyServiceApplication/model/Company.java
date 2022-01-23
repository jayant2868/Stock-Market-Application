package com.project.stockmarket.CompanyServiceApplication.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
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
	
	@OneToMany(targetEntity = Ipo.class, cascade = CascadeType.ALL)
	@JoinColumn(name="company_id", referencedColumnName ="id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Ipo> ipos;

	@OneToMany(targetEntity = StockPrices.class, cascade = CascadeType.ALL)
	@JoinColumn(name="company_id", referencedColumnName ="id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<StockPrices> stockPrices = new ArrayList<>();
	
	public Company()
	{
		
	}

	public Company(Long id, String name, String code, String turnover, String ceo, String boardOfDirectors,
			String stockExchangeNames, String sectorName, String description, List<Ipo> ipos,
			List<StockPrices> stockPrices) {
		
		this.id = id;
		this.name = name;
		this.code = code;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.stockExchangeNames = stockExchangeNames;
		this.sectorName = sectorName;
		this.description = description;
		this.ipos = ipos;
		this.stockPrices = stockPrices;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", code=" + code + ", turnover=" + turnover + ", ceo=" + ceo
				+ ", boardOfDirectors=" + boardOfDirectors + ", stockExchangeNames=" + stockExchangeNames
				+ ", sectorName=" + sectorName + ", description=" + description + ", ipos=" + ipos + ", stockPrices="
				+ stockPrices + "]";
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

	public List<Ipo> getIpos() {
		return ipos;
	}

	public void setIpos(List<Ipo> ipos) {
		this.ipos = ipos;
	}

	public List<StockPrices> getStockPrices() {
		return stockPrices;
	}

	public void setStockPrices(List<StockPrices> stockPrices) {
		this.stockPrices = stockPrices;
	}

	public Company(Long id, String name, String code, String turnover, String ceo, String boardOfDirectors,
			String stockExchangeNames, String sectorName, String description) {
		
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
	
	
	
}
