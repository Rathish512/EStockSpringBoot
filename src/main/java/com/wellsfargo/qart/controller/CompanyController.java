package com.wellsfargo.qart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.qart.dto.CompanyDTO;
import com.wellsfargo.qart.exception.CompanyException;
import com.wellsfargo.qart.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/add-company")
	public ResponseEntity<String> addCompany(@RequestBody @Valid CompanyDTO company,BindingResult result) throws CompanyException{
		if(result.hasErrors()) {
			throw new CompanyException(GlobalExceptionController.errMsgFrom(result));
		}
		companyService.addNewCompany(company);
		return ResponseEntity.accepted().body("Record Inserted Successfully");
	}
	
	@DeleteMapping("/deleteCompany/{companyCode}")
	public ResponseEntity<String> deleteCompany(@PathVariable("companyCode")Long companyCode) throws CompanyException{
		companyService.deleteCompany(companyCode);	
		return ResponseEntity.accepted().body("Deleted Successfully");
	}
}
