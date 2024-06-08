package com.orchasp.contactInformationSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.orchasp.contactInformationSystem.entity.Organization;
import com.orchasp.contactInformationSystem.repo.Orgrepo;

@Repository
public class OrgDaoImpl implements OrgDao {
	
	@Autowired
	private Orgrepo repo;

	@Override
	public Organization saveOrganization(Organization org) {
		return repo.save(org);
	}

	@Override
	public List<Organization> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Organization fetchById(int id) {
		Optional<Organization> op=repo.findById(id);
		if(op.isPresent())
			return op.get();
		else
		return null;
	}

	@Override
	public Organization updateOrganization(int id,Organization org) {
		Optional<Organization> op=repo.findById(id);
		
		if(op.isPresent()) {
			Organization cs=op.get();
			if(org.getId()!=0)
				cs.setId(org.getId());
			if(org.getOrgCode()!=null)
				cs.setOrgCode(org.getOrgCode());
			if(org.getPlace()!=null)
				cs.setPlace(org.getPlace());
			if(org.getAddress1()!=null)
				cs.setAddress1(org.getAddress1());
			if(org.getAddress2()!=null)
				cs.setAddress2(org.getAddress2());
			if(org.getPhoneNum()!=0)
				org.setPhoneNum(org.getPhoneNum());
			if(org.getDateOfReg()!=null)
				cs.setDateOfReg(org.getDateOfReg());
			if(org.getCstNo()!=null)
				cs.setCstNo(org.getCstNo());
			if(org.getCeCode()!=null)
				cs.setCeCode(org.getCeCode());
			if(org.getEmail()!=null)
				cs.setEmail(org.getEmail());
			if(org.getDrclNo()!=null)
				cs.setDrclNo(org.getDrclNo());
			if(org.getPanGir()!=null)
				cs.setPanGir(org.getPanGir());
			if(org.getEximCode()!=null)
				cs.setEximCode(org.getEximCode());
			if(org.getGstRate()!=null)
				cs.setGstRate(org.getGstRate());
			if(org.getOrgName()!=null)
				cs.setOrgName(org.getOrgName());
			if(org.getPincode()!=0)
				cs.setPincode(org.getPincode());
			if(org.getTeleEx()!=null)
				cs.setTeleEx(org.getTeleEx());
			if(org.getGrams()!=null)
				cs.setGrams(org.getGrams());
			if(org.getRegNo()!=null)
				cs.setRegNo(org.getRegNo());
			if(org.getInceptionDate()!=null)
				cs.setInceptionDate(org.getInceptionDate());
			if(org.getGstNo()!=null)
				cs.setGstNo(org.getGstNo());
			if(org.getCerNo()!=null)
				cs.setCerNo(org.getCerNo());
			if(org.getFromDate()!=null)
				cs.setFromDate(org.getFromDate());
			if(org.getTdsAccount()!=null)
				cs.setTdsAccount(org.getTdsAccount());
			if(org.getPanExt()!=null)
				cs.setPanExt(org.getPanExt());
			if(org.getCstRate()!=null)
				cs.setCstRate(org.getCstRate());
			if(org.getExciseDutyRate()!=null)
				cs.setExciseDutyRate(org.getExciseDutyRate());
			return repo.save(cs);
		}
		else
		return null;
	}

	@Override
	public Organization deleteById(int id) {
		Optional<Organization> op=repo.findById(id);
		if(op.isPresent()) {
			repo.deleteById(id);
			return op.get();
		}
		else
		return null;
	}

}
