package com.wellsfargo.qart.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StockDTO {
	
    private Long stockId;
    
    private Long companyCode;
	
	@NotNull
	@Column(precision = 10, scale = 2)
	private Double currentStockPrice;
	
	@NotNull(message = "Stock Price Date is mandatory")
	@DateTimeFormat(iso=ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate stockPriceDate;
	
	@NotNull(message = "Stock Price Time is mandatory")
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime stockPriceTime;

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
	
	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public StockDTO(Long id2, Double currentStockPrice2, LocalDate stockPriceDate2, LocalTime stockPriceTime2) {
	}

	public StockDTO() {

	}

	
	
}
