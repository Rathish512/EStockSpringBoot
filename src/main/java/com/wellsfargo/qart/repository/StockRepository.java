package com.wellsfargo.qart.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.qart.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity,Long>{
	
	@Query("SELECT C.companyCode,C.boardOfDirectors,C.companyCEO,C.companyName,C.companyProfile,C.stockExchange,C.turnOver,S.currentStockPrice,S.stockPriceDate,S.stockPriceTime FROM CompanyEntity C INNER JOIN StockEntity S ON C.companyCode=S.companyCode AND C.companyCode=?1")
    public List<StockEntity> findStockDetailsByCode(Long companyCode);

    @Query("select s FROM StockEntity s where s.companyCode=?1 and s.stockPriceDate between ?2 and ?3")
    public List<StockEntity> findStockPriceIndex(Long companyCode,  LocalDate start,  LocalDate end);

    @Query("SELECT min(currentStockPrice) from StockEntity s where s.companyCode=?1 and s.stockPriceDate between ?2 and ?3")
	public Double min(Long companyCode,  LocalDate start,  LocalDate end);

	@Query( "SELECT max(currentStockPrice) from StockEntity s where s.companyCode=?1 and s.stockPriceDate between ?2 and ?3")
    public Double max(Long companyCode,  LocalDate start,  LocalDate end);
    
    @Query( "SELECT avg(currentStockPrice) from StockEntity s where s.companyCode=?1 and s.stockPriceDate between ?2 and ?3")
	public Double avg(Long companyCode,  LocalDate start,  LocalDate end); 

}
