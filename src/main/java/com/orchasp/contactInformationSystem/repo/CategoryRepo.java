package com.orchasp.contactInformationSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orchasp.contactInformationSystem.entity.Categories;

public interface CategoryRepo extends JpaRepository<Categories, Integer> {

}
