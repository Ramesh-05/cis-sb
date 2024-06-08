package com.orchasp.contactInformationSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orchasp.contactInformationSystem.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	@Query("SELECT a FROM Admin a WHERE a.adminUsername = ?1 AND a.adminPassword = ?2")
	public Admin findByAdminUserIdAndPassword(String adminUsername,String adminPassword);
	
//	Admin findByAdminUsername(String adminUsername);
}
