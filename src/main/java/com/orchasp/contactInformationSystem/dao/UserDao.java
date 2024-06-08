package com.orchasp.contactInformationSystem.dao;

import java.util.List;

import com.orchasp.contactInformationSystem.entity.Users;


public interface UserDao {
	
	public Users saveUser(Users u);
	
	public List<Users> fetchAll();
	
	public Users fetchById(int id);
	
	public Users updateUser(int memberId,Users s);
	
	public Users deleteById(int id);


}
