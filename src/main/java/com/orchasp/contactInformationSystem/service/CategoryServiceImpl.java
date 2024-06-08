package com.orchasp.contactInformationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orchasp.contactInformationSystem.dao.CategoryDaoImpl;
import com.orchasp.contactInformationSystem.entity.Categories;
import com.orchasp.contactInformationSystem.exception.UserNotFound;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDaoImpl dao;

	@Override
	public ResponseEntity<ResponseStructure<Categories>> saveCategory(Categories category) {
		ResponseStructure<Categories> r=new ResponseStructure<Categories>();
		r.setData(dao.saveUser(category));
		r.setMessage("category data saved successfully");
		r.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Categories>>(r,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Categories>> fetchCategory(int categoryId) {
		Categories db=dao.fetchById(categoryId);
		if(db!=null) {

			ResponseStructure<Categories> m=new ResponseStructure<Categories>();
			m.setData(db);
			m.setMessage("category found successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Categories>>(m,HttpStatus.FOUND);
		}else {
			throw new UserNotFound("category not found....") ;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Categories>> updateCategory(int categoryId,Categories category) {
		Categories db = dao.fetchById(category.getCategoryId());
		if (db != null) {
			ResponseStructure<Categories> m = new ResponseStructure<Categories>();
			m.setData(dao.updateCategory(categoryId,category));
			m.setMessage("category data fetched successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Categories>>(m, HttpStatus.FOUND);
		} else {
			throw new UserNotFound("no category found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Categories>> deleteCategory(int categoryId) {
		Categories db = dao.deleteById(categoryId);
		if(db!=null) {
		ResponseStructure<Categories> s=new ResponseStructure<Categories>();
		s.setData(db);
		s.setMessage("category found successfully.........");
		s.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Categories>>(s,HttpStatus.FOUND);
		}
		else {
			throw new UserNotFound("category not found for id:"+categoryId);
		}
	}

}
