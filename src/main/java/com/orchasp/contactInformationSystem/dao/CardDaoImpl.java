package com.orchasp.contactInformationSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orchasp.contactInformationSystem.entity.Card;
import com.orchasp.contactInformationSystem.repo.CardRepo;


@Repository
public class CardDaoImpl implements CardDao {
	
	@Autowired
	private CardRepo repo;

	@Override
	public Card saveCard(Card card) {
		return repo.save(card);
	}

	@Override
	public List<Card> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Card fetchById(int id) {
		Optional<Card> op=repo.findById(id);
		if(op.isPresent())
			return op.get();
		else
			return null;
	}

	@Override
	public Card updateCard(int cardId,Card s) {
		Optional<Card> op=repo.findById(cardId);
		
		if(op.isPresent()) {
			Card cs=op.get();
			if(s.getCardId()!=0)
				cs.setCardId(s.getCardId());
			if(s.getName()!=null)
				cs.setName(s.getName());
			if(s.getCompanyName()!=null)
				cs.setCompanyName(s.getCompanyName());
			if(s.getAddress()!=null)
				cs.setAddress(s.getAddress());
			if(s.getBranches()!=null)
				cs.setBranches(s.getBranches());
			if(s.getCardType()!=null)
				cs.setCardType(s.getCardType());
			if(s.getDepartment()!=null)
				cs.setDepartment(s.getDepartment());
			if(s.getDesignation()!=null)
				cs.setDesignation(s.getDesignation());
			if(s.getEmail()!=null)
				cs.setEmail(s.getEmail());
			if(s.getMobileNum()!=0)
				cs.setMobileNum(s.getMobileNum());
			if(s.getOffEmail()!=null)
				cs.setOffEmail(s.getOffEmail());
			if(s.getOffWebsite()!=null)
				cs.setOffWebsite(s.getOffWebsite());
			if(s.getResidentialNumber()!=0)
				cs.setResidentialNumber(s.getResidentialNumber());
			if(s.getPartner()!=null)
				cs.setPartner(s.getPartner());
			if(s.getCategory()!=null)
				cs.setCategory(s.getCategory());
			return repo.save(cs);
		}
		else
			return null;
	}

	@Override
	public Card deleteById(int id) {
		Optional<Card> op=repo.findById(id);
		if(op.isPresent()) {
			repo.deleteById(id);
			return op.get();
		}
		else
			return null;
	}

}
