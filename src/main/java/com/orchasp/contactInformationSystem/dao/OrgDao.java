package com.orchasp.contactInformationSystem.dao;

import java.util.List;

import com.orchasp.contactInformationSystem.entity.Organization;

public interface OrgDao {
	
	public Organization saveOrganization(Organization org);
	public List<Organization> fetchAll();
	
	public Organization fetchById(int id);
	
	public Organization updateOrganization(int id,Organization org);
	
	public Organization deleteById(int id);

}
