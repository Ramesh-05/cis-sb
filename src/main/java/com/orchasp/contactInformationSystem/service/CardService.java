package com.orchasp.contactInformationSystem.service;

import org.springframework.http.ResponseEntity;

import com.orchasp.contactInformationSystem.entity.Card;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

public interface CardService {
	
	public ResponseEntity<ResponseStructure<Card>> saveCard(Card card);
	
	public ResponseEntity<ResponseStructure<Card>> fetchCard(int cardId);
	
	public ResponseEntity<ResponseStructure<Card>> updateCard(int cardId,Card card);
	
	public ResponseEntity<ResponseStructure<Card>>deleteCard(int cardId);


}
