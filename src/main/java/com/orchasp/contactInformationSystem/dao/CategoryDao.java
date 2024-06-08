package com.orchasp.contactInformationSystem.dao;

import java.util.List;

import com.orchasp.contactInformationSystem.entity.Categories;

public interface CategoryDao {
	
public Categories saveUser(Categories c);
	
	public List<Categories> fetchAll();
	
	public Categories fetchById(int id);
	
	public Categories updateCategory(int categoryId,Categories s);
	
	public Categories deleteById(int id);

}
