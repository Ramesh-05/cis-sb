package com.orchasp.contactInformationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orchasp.contactInformationSystem.dao.CategoryDaoImpl;
import com.orchasp.contactInformationSystem.entity.Categories;
import com.orchasp.contactInformationSystem.service.CategoryServiceImpl;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl cservice;
	@Autowired
	private CategoryDaoImpl dao;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Categories>> saveCategory(@RequestBody Categories category){
		return cservice.saveCategory(category);
	}
	@GetMapping("/fetch/{categoryId}")
	public Categories fetchCategory(@PathVariable int categoryId){
		return dao.fetchById(categoryId);
	}
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<ResponseStructure<Categories>> updateCategory(@PathVariable int categoryId, @RequestBody Categories category){
		return cservice.updateCategory(categoryId, category);
	}
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<ResponseStructure<Categories>> deleteCategory(@PathVariable int categoryId){
		return cservice.deleteCategory(categoryId);
	}
	
	@GetMapping("/fetchall")
	public List<Categories> fetchAll() {
		return dao.fetchAll();
	}

}
