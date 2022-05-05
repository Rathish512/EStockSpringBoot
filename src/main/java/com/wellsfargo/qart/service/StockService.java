package com.wellsfargo.qart.service;

import java.time.LocalDate;
import java.util.List;

import com.wellsfargo.qart.dto.StockDTO;
import com.wellsfargo.qart.dto.StockPriceIndexDTO;
import com.wellsfargo.qart.exception.StockException;

public interface StockService {
	
	StockDTO addNewStock(StockDTO stockDTO) throws StockException;
	List<StockDTO> getStockByCompanyCode(Long companyCode) throws StockException;
	public StockPriceIndexDTO getStockPriceIndex(Long companyCode, LocalDate startDate, LocalDate endDate) throws StockException;
}
