package com.wellsfargo.qart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="companies")
public class CompanyEntity {
	
	@Id
	@Column(name="company_Code")
	private Long companyCode;
	
	@Column(name="stockExchange")
	private String stockExchange;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="companyCEO")
	private String companyCEO;
	
	@Column(name="turnOver",precision=10, scale=2)
	private Double turnOver;
	
	@Column(name="boardOfDirectors")
	private String boardOfDirectors;
	
	@Column(name="companyProfile")
	private String companyProfile;
	
	public CompanyEntity() {
		
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

	public CompanyEntity(Long companyCode, String stockExchange, String companyName, String companyCEO, Double turnOver,
			String boardOfDirectors, String companyProfile) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.turnOver = turnOver;
		this.boardOfDirectors = boardOfDirectors;
		this.companyProfile = companyProfile;
	}
}
