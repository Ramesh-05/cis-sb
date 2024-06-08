package com.orchasp.contactInformationSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orchasp.contactInformationSystem.entity.Categories;
import com.orchasp.contactInformationSystem.repo.CategoryRepo;
@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private CategoryRepo repo;

	@Override
	public Categories saveUser(Categories c) {
		return repo.save(c);
	}

	@Override
	public List<Categories> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Categories fetchById(int id) {
		Optional<Categories> op=repo.findById(id);
		if(op.isPresent())
			return op.get();
		else
			return null;
	}

	@Override
	public Categories updateCategory(int categoryId,Categories s) {
		Optional<Categories> op=repo.findById(categoryId);
		
		if(op.isPresent()) {
			Categories cs=op.get();
			if(s.getCategoryId()!=0)
				cs.setCategoryId(s.getCategoryId());
			if(s.getCategoryName()!=null)
				cs.setCategoryName(s.getCategoryName());
			if(s.getShortName()!=null)
				cs.setShortName(s.getShortName());
			return repo.save(cs);
		}
		else
			return null;
	}

	@Override
	public Categories deleteById(int id) {
		Optional<Categories> op=repo.findById(id);
		if(op.isPresent()) {
			repo.deleteById(id);
			return op.get();
		}
		else
			return null;
	}

}
