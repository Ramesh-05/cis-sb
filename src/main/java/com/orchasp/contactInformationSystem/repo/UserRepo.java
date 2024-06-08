package com.orchasp.contactInformationSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.orchasp.contactInformationSystem.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
	
	@Query("SELECT a FROM Users a WHERE a.name = ?1 AND a.password = ?2")
	public Users findByUserIdAndPassword(String name,String password);
	

}
