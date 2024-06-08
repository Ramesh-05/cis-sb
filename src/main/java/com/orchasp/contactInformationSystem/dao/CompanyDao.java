package com.orchasp.contactInformationSystem.dao;

import java.util.List;

import com.orchasp.contactInformationSystem.entity.Company;


public interface CompanyDao {

	public Company saveCompany(Company company);
	
	public List<Company> fetchAll();
	
	public Company fetchById(int id);
	
	public Company updateCompany(int companyId,Company com);
	
	public Company deleteById(int id);
}
