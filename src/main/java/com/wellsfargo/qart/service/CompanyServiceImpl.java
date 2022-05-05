package com.wellsfargo.qart.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.qart.dto.CompanyDTO;
import com.wellsfargo.qart.entity.CompanyEntity;
import com.wellsfargo.qart.exception.CompanyException;
import com.wellsfargo.qart.repository.CompanyRepository;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyEntity toEntity(CompanyDTO model) {
		return new CompanyEntity(model.getCompanyCode(),model.getStockExchange(),model.getCompanyName(),
				model.getCompanyCEO(),model.getTurnOver(),model.getBoardOfDirectors(),model.getCompanyProfile());
	}
	
	public CompanyDTO toModel(CompanyEntity entity) {
		return new CompanyDTO(entity.getCompanyCode(),entity.getStockExchange(),entity.getCompanyName(),
				entity.getCompanyCEO(),entity.getTurnOver(),entity.getBoardOfDirectors(),entity.getCompanyProfile());
	}

	@Override
	public CompanyDTO addNewCompany(CompanyDTO companyDTO) throws CompanyException {
		
		if(companyRepository!=null) {
			
			companyDTO=toModel(companyRepository.save(toEntity(companyDTO)));
		}
		
		return companyDTO;
	}

	@Override
	public boolean deleteCompany(Long companyCode) throws CompanyException {
		if(!companyRepository.existsById(companyCode)) {
			throw new CompanyException("Company Not Found");
		}
		companyRepository.deleteById(companyCode);
		return true;
	}

	@Override
	public CompanyDTO getCompanyInfoById(Long companyCode) {
		if (companyCode == null) {
            return null;
        }

        CompanyEntity companyInfo = companyRepository.findCompanyDetailsById(companyCode);

        return toModel(companyInfo);
	}
	
	

}
