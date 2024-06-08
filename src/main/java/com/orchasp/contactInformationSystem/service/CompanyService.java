package com.orchasp.contactInformationSystem.service;

import org.springframework.http.ResponseEntity;

import com.orchasp.contactInformationSystem.entity.Company;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

public interface CompanyService {
	
	public ResponseEntity<ResponseStructure<Company>> saveCompany(Company company);
	
	public ResponseEntity<ResponseStructure<Company>> fetchCompany(int companyId);
	
	public ResponseEntity<ResponseStructure<Company>> updateCompany(int companyId,Company company);
	
	public ResponseEntity<ResponseStructure<Company>>deleteCompany(int companyId);

}
