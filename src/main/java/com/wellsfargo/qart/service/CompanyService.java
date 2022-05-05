package com.wellsfargo.qart.service;

import com.wellsfargo.qart.dto.CompanyDTO;
import com.wellsfargo.qart.exception.CompanyException;

public interface CompanyService {
	
	CompanyDTO addNewCompany(CompanyDTO companyDTO) throws CompanyException;
	boolean deleteCompany(Long companyCode) throws CompanyException;
	CompanyDTO getCompanyInfoById(Long companyCode);
}
