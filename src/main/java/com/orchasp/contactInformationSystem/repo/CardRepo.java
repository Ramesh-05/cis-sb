package com.orchasp.contactInformationSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orchasp.contactInformationSystem.entity.Card;

public interface CardRepo extends JpaRepository<Card, Integer> {

}
