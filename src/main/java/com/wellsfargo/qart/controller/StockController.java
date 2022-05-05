package com.wellsfargo.qart.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.qart.dto.StockDTO;
import com.wellsfargo.qart.dto.StockPriceIndexDTO;
import com.wellsfargo.qart.exception.CompanyException;
import com.wellsfargo.qart.exception.StockException;
import com.wellsfargo.qart.service.CompanyService;
import com.wellsfargo.qart.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@Autowired
	CompanyService companyService;
	
	@PostMapping("/add-stock") 
    public ResponseEntity<String> addStock(@RequestBody @Valid StockDTO stock, BindingResult result) throws StockException {
        if (result.hasErrors()) {
            throw new StockException(GlobalExceptionController.errMsgFrom(result));
        }   
           stockService.addNewStock(stock);
           return ResponseEntity.accepted().body("Record Inserted Successfully");    
	}

	@GetMapping("/getStockByCompanyCode/{companyCode}")
	public ResponseEntity<List<StockDTO>> getAllStocksByCompanyCode(@PathVariable("companyCode")Long companyCode) throws StockException
	{

		return new ResponseEntity<>(stockService.getStockByCompanyCode(companyCode),HttpStatus.OK);
	}
	
	@GetMapping("/getStockPriceIndex/{companyCode}/{startDate}/{endDate}") 
	public ResponseEntity<StockPriceIndexDTO> displayStockPriceIndex(@PathVariable Long companyCode,
	            @PathVariable Date startDate, @PathVariable Date endDate) throws StockException, CompanyException 
	{
        if (companyCode != null) {
            StockPriceIndexDTO stockPriceIndexDTO = stockService.getStockPriceIndex(companyCode, startDate.toLocalDate(), endDate.toLocalDate());
            if (stockPriceIndexDTO == null) {
                throw new StockException("Stock Not Found");
            }
            return new ResponseEntity<>(stockPriceIndexDTO,HttpStatus.OK);
	        } 
        	else {
        		 throw new CompanyException("Invalid Company Code! Please enter valid companyCode");
        	}
	} 

}
