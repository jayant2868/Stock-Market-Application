package com.project.stockmarket.StockExchange.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table
public class StockExchange {

	
		@Id
		@GeneratedValue
		private Long id;
		
		private String name;

		private String description;

		private String address;

		private String remarks;

		@OneToMany(targetEntity = Company.class, cascade = CascadeType.ALL)
		@JoinColumn(name="stockexchange_id", referencedColumnName ="id")
		@JsonProperty(access = Access.WRITE_ONLY)
		private List<Company> companies = new ArrayList<>();

		public StockExchange() {
			super();
			// TODO Auto-generated constructor stub
		}

		public StockExchange(Long id, String name, String description, String address, String remarks,
				List<Company> companies) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.address = address;
			this.remarks = remarks;
			this.companies = companies;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public List<Company> getCompanies() {
			return companies;
		}

		public void setCompanies(List<Company> companies) {
			this.companies = companies;
		}
		
		
	
}
