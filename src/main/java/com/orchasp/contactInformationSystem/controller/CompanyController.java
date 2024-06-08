package com.orchasp.contactInformationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orchasp.contactInformationSystem.dao.CompanyDaoImpl;
import com.orchasp.contactInformationSystem.entity.Company;
import com.orchasp.contactInformationSystem.service.CompanyServiceImpl;
import com.orchasp.contactInformationSystem.util.ResponseStructure;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/company")
@RestController
public class CompanyController {
	
	@Autowired
	private CompanyServiceImpl companyserv;
	@Autowired
	private CompanyDaoImpl dao;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Company>> saveCompany(@RequestBody Company company){
		return companyserv.saveCompany(company);
	}
	@GetMapping("/fetch/{companyId}")
	public Company fetchCompany(@PathVariable int companyId){
		return dao.fetchById(companyId);
	}
	@PutMapping("/update/{companyId}")
	public ResponseEntity<ResponseStructure<Company>> updateCompany(@PathVariable int companyId, @RequestBody Company company){
		return companyserv.updateCompany(companyId,company);
	}
	@DeleteMapping("/delete/{companyId}")
	public ResponseEntity<ResponseStructure<Company>> deleteCompany(@PathVariable int companyId){
		return companyserv.deleteCompany(companyId);
	}
	
	@GetMapping("/fetchall")
	public List<Company> fetchAll() {
		return dao.fetchAll();
	}

}
