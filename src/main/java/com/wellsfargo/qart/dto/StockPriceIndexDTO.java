package com.wellsfargo.qart.dto;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class StockPriceIndexDTO {
	
	private CompanyDTO companyDto;

    @NotNull
    private List<StockDTO> stockPriceList;

    @Digits(integer = 10, fraction = 2)
    private Double maxStockPrice;

    @Digits(integer = 10, fraction = 2)
    private Double minStockPrice;

    @Digits(integer = 10, fraction = 2)
    private Double avgStockPrice;

	public CompanyDTO getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDTO companyDto) {
		this.companyDto = companyDto;
	}

	public List<StockDTO> getStockPriceList() {
		return stockPriceList;
	}

	public void setStockPriceList(List<StockDTO> stockPriceList) {
		this.stockPriceList = stockPriceList;
	}

	public Double getMaxStockPrice() {
		return maxStockPrice;
	}

	public void setMaxStockPrice(Double maxStockPrice) {
		this.maxStockPrice = maxStockPrice;
	}

	public Double getMinStockPrice() {
		return minStockPrice;
	}

	public void setMinStockPrice(Double minStockPrice) {
		this.minStockPrice = minStockPrice;
	}

	public Double getAvgStockPrice() {
		return avgStockPrice;
	}

	public void setAvgStockPrice(Double avgStockPrice) {
		this.avgStockPrice = avgStockPrice;
	}

	public StockPriceIndexDTO(CompanyDTO companyDto,List<StockDTO> stockPriceList,
			@Digits(integer = 10, fraction = 2) Double maxStockPrice,
			@Digits(integer = 10, fraction = 2) Double minStockPrice,
			@Digits(integer = 10, fraction = 2) Double avgStockPrice) {
		super();
		this.companyDto = companyDto;
		this.stockPriceList = stockPriceList;
		this.maxStockPrice = maxStockPrice;
		this.minStockPrice = minStockPrice;
		this.avgStockPrice = avgStockPrice;
	}

	public StockPriceIndexDTO() {
	}
    
}
