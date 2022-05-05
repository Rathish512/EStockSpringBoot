package com.wellsfargo.qart.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CompanyDTO {
	
	private Long companyCode;
	
	@NotNull(message = "Stock Exchange is mandatory")
	@NotBlank(message = "Stock Exchange is mandatory")
	@Size(min=5,max=50,message = "Stock Exchange should be between 5 to 50 characters")
	private String stockExchange;
	
	@NotNull(message = "CompanyName is mandatory")
	@NotBlank(message = "CompanyName is mandatory")
	@Size(min=5,max=50,message = "CompanyName should be between 5 to 50 characters")
	private String companyName;
	
	@NotNull(message = "CompanyCEO is mandatory")
	@NotBlank(message = "CompanyCEO is mandatory")
	@Size(min=3,max=50,message = "CompanyCEO should be between 3 to 50 characters")
	private String companyCEO;
	
	@NotNull
	@Column(precision=10, scale=2)
	private Double turnOver;
	
	@NotNull(message = "BoardOfDirectors is mandatory")
	@NotBlank(message = "BoardOfDirectors is mandatory")
	@Size(min=5,max=200,message = "BoardOfDirectors should be between 5 to 200 characters")
	private String boardOfDirectors;
	
	@NotNull(message = "CompanyProfile is mandatory")
	@NotBlank(message = "CompanyProfile is mandatory")
	@Size(min=5,max=255,message = "CompanyProfile should be between 5 to 255 characters")
	private String companyProfile;
	
	public CompanyDTO() {
		
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public Double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(Double turnOver) {
		this.turnOver = turnOver;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getCompanyProfile() {
		return companyProfile;
	}

	public void setCompanyProfile(String companyProfile) {
		this.companyProfile = companyProfile;
	}
	
	public CompanyDTO(Long companyCode2, String stockExchange2, String companyName2, String companyCEO2,
			Double turnOver2, String boardOfDirectors2, String companyProfile2) {
	}
		
}
