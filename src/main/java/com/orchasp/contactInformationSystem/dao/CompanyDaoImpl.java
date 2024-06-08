package com.orchasp.contactInformationSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.orchasp.contactInformationSystem.entity.Company;
import com.orchasp.contactInformationSystem.repo.CompanyRepo;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	@Autowired
	private CompanyRepo repo;

	@Override
	public Company saveCompany(Company company) {
		return repo.save(company);
	}

	@Override
	public List<Company> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Company fetchById(int id) {
		Optional<Company> op = repo.findById(id);
		if (op.isPresent())
			return op.get();
		else
			return null;
	}

	@Override
	public Company updateCompany(int companyId,Company com) {
		Optional<Company> op = repo.findById(companyId);
		
		if (op.isPresent()) {
			Company cs = op.get();
			if (com.getCompanyId() != 0)
				cs.setCompanyId(com.getCompanyId());
			if (com.getCity() != null)
				cs.setCity(com.getCity());
			if (com.getCompanyName() != null)
				cs.setCompanyName(com.getCompanyName());
			if (com.getAddress() != null)
				cs.setAddress(com.getAddress());
			if (com.getPincode() != 0)
				cs.setPincode(com.getPincode());
			if (com.getWebAddress() != null)
				cs.setWebAddress(com.getWebAddress());
			if (com.getEmail() != null)
				cs.setEmail(com.getEmail());
			if (com.getContactNumber() != 0)
				cs.setContactNumber(com.getContactNumber());
			if (com.getActive() != null)
				cs.setActive(com.getActive());
			if (com.getState() != null)
				cs.setState(com.getState());
			return repo.save(cs);
		} else
			return null;
	}

	@Override
	public Company deleteById(int id) {
		Optional<Company> op = repo.findById(id);
		if (op.isPresent()) {
			repo.deleteById(id);
			return op.get();
		} else
			return null;
	}

}
