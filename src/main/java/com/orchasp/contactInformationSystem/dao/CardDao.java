package com.orchasp.contactInformationSystem.dao;

import java.util.List;

import com.orchasp.contactInformationSystem.entity.Card;

public interface CardDao {
	
	public Card saveCard(Card card);
	
	public List<Card> fetchAll();
	
	public Card fetchById(int id);
	
	public Card updateCard(int cardId,Card s);
	
	public Card deleteById(int id);

}
