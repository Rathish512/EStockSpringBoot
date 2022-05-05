package com.wellsfargo.qart.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.qart.dto.CompanyDTO;
import com.wellsfargo.qart.dto.StockDTO;
import com.wellsfargo.qart.dto.StockPriceIndexDTO;
import com.wellsfargo.qart.entity.StockEntity;
import com.wellsfargo.qart.exception.StockException;
import com.wellsfargo.qart.repository.StockRepository;

@Service
@Transactional
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	CompanyService companyService;
	
	private StockEntity toEntity(StockDTO model) {
		return new StockEntity(model.getStockId(),model.getCompanyCode(),model.getCurrentStockPrice(),model.getStockPriceDate(),model.getStockPriceTime());
	}
	
	private StockDTO toModel(StockEntity entity) {
		return new StockDTO(entity.getStockId(),entity.getCurrentStockPrice(),entity.getStockPriceDate(),entity.getStockPriceTime());
	}
	
	private List<StockDTO> convertToStockDetailsDtoList(
            List<StockEntity> stockDetailsList) {

        if (stockDetailsList == null || stockDetailsList.isEmpty()) {
            return null;
        }
        List<StockDTO> list = new ArrayList<>();

        for (StockEntity stockDto : stockDetailsList) {
            list.add(toModel(stockDto));
        }
        return list;
    }

	@Override
	public StockDTO addNewStock(StockDTO stockDTO) throws StockException {	
		StockEntity newStock = toEntity(stockDTO);
		stockRepository.save(newStock);
		return stockDTO;
	}

	@Override
	public List<StockDTO> getStockByCompanyCode(Long companyCode) throws StockException {
		List<StockEntity> stockDetailsList = stockRepository.findStockDetailsByCode(companyCode);
		return convertToStockDetailsDtoList(stockDetailsList);
	}
	
	public Double getMaxStockPrice(Long companyCode, LocalDate startDate, LocalDate endDate) {
	    return stockRepository.max(companyCode, startDate, endDate);
	}

	public Double getAvgStockPrice(Long companyCode, LocalDate startDate, LocalDate endDate) {
	    return stockRepository.avg(companyCode, startDate, endDate);
	}

	public Double getMinStockPrice(Long companyCode, LocalDate startDate, LocalDate endDate) {
	    return stockRepository.min(companyCode, startDate, endDate);
	}

	@Override
	public StockPriceIndexDTO getStockPriceIndex(Long companyCode, LocalDate startDate, LocalDate endDate)
			throws StockException {
		CompanyDTO companyDto = companyService.getCompanyInfoById(companyCode);

        if (companyDto == null) {
            return null;
        }
        List<StockEntity> stockPriceDetails = stockRepository.findStockPriceIndex(companyCode, startDate,
                endDate);

        Double maxStockPrice = getMaxStockPrice(companyCode, startDate, endDate);
        Double minStockPrice = getMinStockPrice(companyCode, startDate, endDate);
        Double avgStockPrice = getAvgStockPrice(companyCode, startDate, endDate);
        return new StockPriceIndexDTO(companyDto,
                convertToStockDetailsDtoList(stockPriceDetails), maxStockPrice, minStockPrice,
                avgStockPrice);

	}	
	
}
