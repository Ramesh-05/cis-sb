package com.orchasp.contactInformationSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orchasp.contactInformationSystem.entity.Organization;

public interface Orgrepo extends JpaRepository<Organization, Integer> {

}