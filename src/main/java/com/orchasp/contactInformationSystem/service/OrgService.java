package com.orchasp.contactInformationSystem.service;

import org.springframework.http.ResponseEntity;

import com.orchasp.contactInformationSystem.entity.Organization;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

public interface OrgService {
	
	public ResponseEntity<ResponseStructure<Organization>> saveOrganization (Organization org);
	
	public ResponseEntity<ResponseStructure<Organization>> fetchOrganization(int orgId);
	
	public ResponseEntity<ResponseStructure<Organization>> updateOrganization(int id,Organization org);
	
	public ResponseEntity<ResponseStructure<Organization>>deleteOrganization(int orgId);
}
