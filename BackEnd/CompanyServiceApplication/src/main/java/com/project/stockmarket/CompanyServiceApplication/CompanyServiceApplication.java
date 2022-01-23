package com.project.stockmarket.CompanyServiceApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.stockmarket.CompanyServiceApplication.controller.CompanyController;
import com.project.stockmarket.CompanyServiceApplication.model.Company;
import com.project.stockmarket.CompanyServiceApplication.model.Ipo;

import com.project.stockmarket.CompanyServiceApplication.model.StockPrices;

@SpringBootApplication
public class CompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	
	}

}
