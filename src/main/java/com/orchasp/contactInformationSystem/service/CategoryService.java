package com.orchasp.contactInformationSystem.service;

import org.springframework.http.ResponseEntity;

import com.orchasp.contactInformationSystem.entity.Categories;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

public interface CategoryService {
	
	public ResponseEntity<ResponseStructure<Categories>> saveCategory(Categories category);
	
	public ResponseEntity<ResponseStructure<Categories>> fetchCategory(int categoryId);
	
	public ResponseEntity<ResponseStructure<Categories>> updateCategory(int categoryId,Categories category);
	
	public ResponseEntity<ResponseStructure<Categories>>deleteCategory(int categoryId);

}
