package com.wellsfargo.qart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.qart.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,Long>{
	
	@Query("select cd FROM CompanyEntity cd WHERE cd.companyCode=?1")
    public CompanyEntity findCompanyDetailsById(Long companyCode);

}
