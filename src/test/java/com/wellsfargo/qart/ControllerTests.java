package com.wellsfargo.qart;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.qart.dto.CompanyDTO;
import com.wellsfargo.qart.dto.StockDTO;
import com.wellsfargo.qart.repository.CompanyRepository;
import com.wellsfargo.qart.repository.StockRepository;
import com.wellsfargo.qart.service.CompanyService;
import com.wellsfargo.qart.service.StockService;

@WebMvcTest
@RunWith(SpringRunner.class)
class ControllerTests {
	
	@MockBean
	private CompanyService companyService;
	
	@MockBean
	private StockService stockService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CompanyRepository companyRepo;
	
	@MockBean
	private StockRepository stockRepo;
	
	private static ObjectMapper mapper = new ObjectMapper();
	 
	 @Test
	 void testCompanyController() throws Exception
	 {
		 CompanyDTO company = new CompanyDTO();
			company.setCompanyCode(2L);
			company.setStockExchange("Bombay Stock Exchange");
			company.setCompanyName("LICINDIA");
			company.setCompanyCEO("William");
			company.setTurnOver(5000.00);
			company.setBoardOfDirectors("William");
			company.setCompanyProfile("Insurance");
			Mockito.when(companyService.addNewCompany(ArgumentMatchers.any())).thenReturn(company);
			 String json = mapper.writeValueAsString(company);
		mockMvc.perform(post("/company/add-company").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted());
		
		mockMvc.perform(delete("/company/deleteCompany/2").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted());
		
	 }
	 
	 @Test
		void testStockController() throws Exception
		{
			StockDTO stock = new StockDTO();
			stock.setStockId(1L);
			stock.setCompanyCode(1L);
			stock.setCurrentStockPrice(1000.00);
			Mockito.when(stockService.addNewStock(ArgumentMatchers.any())).thenReturn(stock);
			 String json = mapper.writeValueAsString(stock);
			 mockMvc.perform(post("/stock/add-stock").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
	           .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
			 mockMvc.perform(get("/stock/getStockByCompanyCode/1").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
	            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
			 mockMvc.perform(get("/stock/getStockPriceIndex/2022-05-04/2022-05-05").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
	            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
		}

}
