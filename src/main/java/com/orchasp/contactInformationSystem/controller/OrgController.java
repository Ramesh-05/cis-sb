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

import com.orchasp.contactInformationSystem.dao.OrgDaoImpl;
import com.orchasp.contactInformationSystem.entity.Organization;
import com.orchasp.contactInformationSystem.service.OrgServiceImpl;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/organization")
@RestController
public class OrgController {

	@Autowired
	private OrgServiceImpl orgserv;
	@Autowired
	private OrgDaoImpl dao;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Organization>> saveOrganization(@RequestBody Organization org){		
		return orgserv.saveOrganization(org);
		
	}

	@GetMapping("/fetch/{orgId}")
	public Organization fetchOrganization(@PathVariable int orgId) {
		return dao.fetchById(orgId);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Organization>> updateOrganization(@PathVariable int id, @RequestBody Organization org) {
		return orgserv.updateOrganization(id,org);
	}

	@DeleteMapping("/delete/{orgId}")
	public ResponseEntity<ResponseStructure<Organization>> deleteOrganization(@PathVariable int orgId) {
		return orgserv.deleteOrganization(orgId);
	}

	@GetMapping("/fetchall")
	public List<Organization> fetchAll() {
		return dao.fetchAll();
	}

}
