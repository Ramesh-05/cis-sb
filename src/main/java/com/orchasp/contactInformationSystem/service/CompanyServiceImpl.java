package com.orchasp.contactInformationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orchasp.contactInformationSystem.dao.CompanyDaoImpl;
import com.orchasp.contactInformationSystem.entity.Company;
import com.orchasp.contactInformationSystem.exception.UserNotFound;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDaoImpl dao;

	@Override
	public ResponseEntity<ResponseStructure<Company>> saveCompany(Company company) {
		ResponseStructure<Company> r=new ResponseStructure<Company>();
		r.setData(dao.saveCompany(company));
		r.setMessage("company data saved successfully");
		r.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Company>>(r,HttpStatus.CREATED);
	
	}

	@Override
	public ResponseEntity<ResponseStructure<Company>> fetchCompany(int companyId) {
		Company db=dao.fetchById(companyId);
		if(db!=null) {

			ResponseStructure<Company> m=new ResponseStructure<Company>();
			m.setData(db);
			m.setMessage("company found successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Company>>(m,HttpStatus.FOUND);
		}else {
			throw new UserNotFound("company not found....");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Company>> updateCompany(int companyId,Company company) {
		Company db = dao.fetchById(company.getCompanyId());
		if (db != null) {
			ResponseStructure<Company> m = new ResponseStructure<Company>();
			m.setData(dao.updateCompany(companyId,company));
			m.setMessage("company data fetched successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Company>>(m, HttpStatus.FOUND);
		} else {
			throw new UserNotFound("no company found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Company>> deleteCompany(int companyId) {
		Company db = dao.deleteById(companyId);
		if(db!=null) {
		ResponseStructure<Company> s=new ResponseStructure<Company>();
		s.setData(db);
		s.setMessage("company found successfully.........");
		s.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Company>>(s,HttpStatus.FOUND);
		}
		else {
			throw new UserNotFound("company not found for id:"+companyId);
		}
	}

}
