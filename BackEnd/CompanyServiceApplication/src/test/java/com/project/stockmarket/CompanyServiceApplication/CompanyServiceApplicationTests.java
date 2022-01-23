package com.project.stockmarket.CompanyServiceApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.stockmarket.CompanyServiceApplication.model.Company;
import com.project.stockmarket.CompanyServiceApplication.repository.CompanyRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CompanyServiceApplicationTests {

	@Autowired
	@Order(1)
	private CompanyRepository companyRepo;
	@Test
	void contextLoads() {
		
	}
	@Order(2)
	@Test
	public void createTest() {
		Company company = new Company();
		company.setBoardOfDirectors("directors");
		company.setCeo("Muskesh Ambani");
		company.setCode("Rel123");
		company.setDescription("Growth is life");
		company.setName("Reliance");
		company.setSectorName("Telecom");
		company.setTurnover("1000000 Cr");
		company.setStockExchangeNames("NSE");
		companyRepo.save(company);
		System.out.println(company.getId());
		assertNotNull(companyRepo.findById(company.getId()).get());
		
	}
	@Order(3)
	@Test
	public void testReadAll () {
		List<Company> list = companyRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Order(4)
	@Test
	public void testRead () {
		
		Company company = companyRepo.findById(1L).get();
		assertEquals("Tata Steel", company.getName());
	}
	@Order(5)
	@Test
	public void testUpdate () {
		
		Company company = companyRepo.findById(1L).get();
		company.setStockExchangeNames("BSE");
		companyRepo.save(company);
		assertEquals("BSE", companyRepo.findById(1L).get().getStockExchangeNames());
	}
	@Order(6)
	@Test
	public void testDelete () {
		companyRepo.deleteById(3L);
		assertThat(companyRepo.existsById(3L)).isFalse();
	}
	

}
