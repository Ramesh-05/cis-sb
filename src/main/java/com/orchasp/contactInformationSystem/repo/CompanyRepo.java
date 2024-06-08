package com.orchasp.contactInformationSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orchasp.contactInformationSystem.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer>{

}
