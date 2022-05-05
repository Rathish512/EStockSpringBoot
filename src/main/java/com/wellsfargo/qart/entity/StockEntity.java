package com.wellsfargo.qart.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stocks")
public class StockEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StockId")
	private Long stockId;
	
	@Column(name="company_Code")
	private Long companyCode;
	
	@Column(name="currentStockPrice",precision=10, scale=2)
	private Double currentStockPrice;
	
	@Column(name="stockPriceDate")
	private LocalDate stockPriceDate;
	
	@Column(name="stockPriceTime")
	private LocalTime stockPriceTime;
	
	public StockEntity()
	{
		
	}

	public Double getCurrentStockPrice() {
		return currentStockPrice;
	}

	public void setCurrentStockPrice(Double currentStockPrice) {
		this.currentStockPrice = currentStockPrice;
	}

	public LocalDate getStockPriceDate() {
		return stockPriceDate;
	}

	public void setStockPriceDate(LocalDate stockPriceDate) {
		this.stockPriceDate = stockPriceDate;
	}

	public LocalTime getStockPriceTime() {
		return stockPriceTime;
	}

	public void setStockPriceTime(LocalTime stockPriceTime) {
		this.stockPriceTime = stockPriceTime;
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public StockEntity(Long stockId, Long companyCode, Double currentStockPrice, LocalDate stockPriceDate,
			LocalTime stockPriceTime) {
		super();
		this.stockId = stockId;
		this.companyCode = companyCode;
		this.currentStockPrice = currentStockPrice;
		this.stockPriceDate = stockPriceDate;
		this.stockPriceTime = stockPriceTime;
	}

}
