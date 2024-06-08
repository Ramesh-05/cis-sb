package com.orchasp.contactInformationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orchasp.contactInformationSystem.dao.OrgDaoImpl;
import com.orchasp.contactInformationSystem.entity.Organization;
import com.orchasp.contactInformationSystem.exception.UserNotFound;
import com.orchasp.contactInformationSystem.util.ResponseStructure;


@Service
public class OrgServiceImpl implements OrgService {
	
	@Autowired
	private OrgDaoImpl dao;

	@Override
	public ResponseEntity<ResponseStructure<Organization>> saveOrganization( Organization org){
		ResponseStructure<Organization> r=new ResponseStructure<Organization>();
		r.setData(dao.saveOrganization(org));
		r.setMessage("organization data saved successfully");
		r.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Organization>>(r,HttpStatus.CREATED);
	
	}

	@Override
	public ResponseEntity<ResponseStructure<Organization>> fetchOrganization(int orgId) {
		Organization db=dao.fetchById(orgId);
		if(db!=null) {

			ResponseStructure<Organization> m=new ResponseStructure<Organization>();
			m.setData(db);
			m.setMessage("Organization found successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Organization>>(m,HttpStatus.FOUND);
		}else {
			throw new UserNotFound("Organization not found....") ;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Organization>> updateOrganization(int id,Organization org) {
		Organization db = dao.fetchById(id);
		if (db != null) {
			ResponseStructure<Organization> m = new ResponseStructure<Organization>();
			m.setData(dao.updateOrganization(id,org));
			m.setMessage("Organization data fetched successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Organization>>(m, HttpStatus.FOUND);
		} else {
			throw new UserNotFound("no Organization found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Organization>> deleteOrganization(int orgId) {
		Organization db = dao.deleteById(orgId);
		if(db!=null) {
		ResponseStructure<Organization> s=new ResponseStructure<Organization>();
		s.setData(db);
		s.setMessage("Organization found successfully.........");
		s.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Organization>>(s,HttpStatus.FOUND);
		}
		else {
			throw new UserNotFound("Organization not found for id:"+orgId);
		}
	}

}
