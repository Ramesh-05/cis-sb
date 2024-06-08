package com.orchasp.contactInformationSystem.service;

import org.springframework.http.ResponseEntity;

import com.orchasp.contactInformationSystem.entity.Users;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

public interface UserService {
	
	public ResponseEntity<ResponseStructure<Users>> saveUser(Users user);
	
	public ResponseEntity<ResponseStructure<Users>> fetchUser(int userId);
	
	public ResponseEntity<ResponseStructure<Users>> updateUser(int memberId,Users user);
	
	public ResponseEntity<ResponseStructure<Users>>deleteUser(int userId);

}
