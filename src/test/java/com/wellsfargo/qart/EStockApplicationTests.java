package com.wellsfargo.qart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.wellsfargo.qart.dto.CompanyDTO;
import com.wellsfargo.qart.dto.StockDTO;
import com.wellsfargo.qart.dto.StockPriceIndexDTO;
import com.wellsfargo.qart.entity.CompanyEntity;
import com.wellsfargo.qart.entity.StockEntity;
import com.wellsfargo.qart.exception.CompanyException;
import com.wellsfargo.qart.exception.StockException;

@SpringBootTest
class EStockApplicationTests {
	
	DateTimeFormatter dateformatter = new DateTimeFormatterBuilder()
			  .parseStrict()
			  .appendPattern("uuuuMMdd")
			  .toFormatter()
			  .withResolverStyle(ResolverStyle.STRICT);
	
	String date = "20220503";
	String time = "11:30:25";
	LocalDate ldate=LocalDate.parse(date, dateformatter);
	LocalTime ltime=LocalTime.parse(time);
	
	@Test
	void CompanyTestConstructor() 
	{
		CompanyEntity company = new CompanyEntity(1L,"National Stock Exchange","Wells Fargo","John",10000.00,"John","Banking");
		assertEquals(1L,company.getCompanyCode());
		assertEquals("National Stock Exchange",company.getStockExchange());
		assertEquals("Wells Fargo",company.getCompanyName());
		assertEquals("John",company.getCompanyCEO());
		assertEquals(10000.00,company.getTurnOver());
		assertEquals("John",company.getBoardOfDirectors());
		assertEquals("Banking",company.getCompanyProfile());
	}
	
	@Test
	void testStockException()
	{
		StockException se=new StockException("Invalid Stock Price Details");
		assertEquals("Invalid Stock Price Details",se.getMessage());
	}
	
	@Test
	void testCompanyException()
	{
		CompanyException ce =new CompanyException("Invalid company Details");
		assertEquals("Invalid company Details",ce.getMessage());
	}
	
	@Test
	void StockTestConstructor()
	{
		
		StockEntity stock=new StockEntity(1L,1L,1000.00,ldate,ltime);
		
		assertEquals(1L,stock.getStockId());
		assertEquals(1L,stock.getCompanyCode());
		assertEquals(1000.00,stock.getCurrentStockPrice());
		assertEquals(ldate,stock.getStockPriceDate());
		assertEquals(ltime,stock.getStockPriceTime());
	}

	@Test
	void CompanyTestSetter()
	{
		CompanyEntity company = new CompanyEntity();
		company.setCompanyCode(2L);
		company.setStockExchange("Bombay Stock Exchange");
		company.setCompanyName("LIC");
		company.setCompanyCEO("William");
		company.setTurnOver(5000.00);
		company.setBoardOfDirectors("William");
		company.setCompanyProfile("Insurance");
		
		assertEquals(2L,company.getCompanyCode());
		assertEquals("Bombay Stock Exchange",company.getStockExchange());
		assertEquals("LIC",company.getCompanyName());
		assertEquals("William",company.getCompanyCEO());
		assertEquals(5000.00,company.getTurnOver());
		assertEquals("William",company.getBoardOfDirectors());
		assertEquals("Insurance",company.getCompanyProfile());
	}
	
	@Test
	void StockTestSetter()
	{
		StockEntity stock = new StockEntity();
		stock.setStockId(1L);
		stock.setCompanyCode(1L);
		stock.setCurrentStockPrice(1000.00);
		stock.setStockPriceDate(ldate);
		stock.setStockPriceTime(ltime);
		
		assertEquals(1L,stock.getStockId());
		assertEquals(1L,stock.getCompanyCode());
		assertEquals(1000.00,stock.getCurrentStockPrice());
		assertEquals(ldate,stock.getStockPriceDate());
		assertEquals(ltime,stock.getStockPriceTime());
	}
	
	@Test
	void StockDTOTestSetter()
	{
		StockDTO stock = new StockDTO();
		stock.setStockId(1L);
		stock.setCompanyCode(1L);
		stock.setCurrentStockPrice(1000.00);
		stock.setStockPriceDate(ldate);
		stock.setStockPriceTime(ltime);
		
		assertEquals(1L,stock.getStockId());
		assertEquals(1L,stock.getCompanyCode());
		assertEquals(1000.00,stock.getCurrentStockPrice());
		assertEquals(ldate,stock.getStockPriceDate());
		assertEquals(ltime,stock.getStockPriceTime());
	}
	
	@Test
	void StockPriceIndexDTOTestSetter()
	{
		StockPriceIndexDTO spiDTO = new StockPriceIndexDTO();
		spiDTO.setAvgStockPrice(150.00);
		spiDTO.setMaxStockPrice(200.00);
		spiDTO.setMinStockPrice(100.00);
		
		assertEquals(150.00,spiDTO.getAvgStockPrice());
		assertEquals(200.00,spiDTO.getMaxStockPrice());
		assertEquals(100.00,spiDTO.getMinStockPrice());
	}
	
	@Test
	void CompanyDTOTestSetter() throws Exception
	{
		CompanyDTO company = new CompanyDTO();
		company.setCompanyCode(2L);
		company.setStockExchange("Bombay Stock Exchange");
		company.setCompanyName("LIC");
		company.setCompanyCEO("William");
		company.setTurnOver(5000.00);
		company.setBoardOfDirectors("William");
		company.setCompanyProfile("Insurance");
		
		assertEquals(2L,company.getCompanyCode());
		assertEquals("Bombay Stock Exchange",company.getStockExchange());
		assertEquals("LIC",company.getCompanyName());
		assertEquals("William",company.getCompanyCEO());
		assertEquals(5000.00,company.getTurnOver());
		assertEquals("William",company.getBoardOfDirectors());
		assertEquals("Insurance",company.getCompanyProfile());
	}
}
