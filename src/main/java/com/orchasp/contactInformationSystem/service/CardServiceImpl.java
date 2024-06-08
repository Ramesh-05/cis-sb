package com.orchasp.contactInformationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orchasp.contactInformationSystem.dao.CardDaoImpl;
import com.orchasp.contactInformationSystem.entity.Card;
import com.orchasp.contactInformationSystem.exception.UserNotFound;
import com.orchasp.contactInformationSystem.util.ResponseStructure;


@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardDaoImpl dao;

	@Override
	public ResponseEntity<ResponseStructure<Card>> saveCard(Card card) {
		ResponseStructure<Card> r=new ResponseStructure<Card>();
		r.setData(dao.saveCard(card));
		r.setMessage("card data saved successfully");
		r.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Card>>(r,HttpStatus.CREATED);
	
	}

	@Override
	public ResponseEntity<ResponseStructure<Card>> fetchCard(int cardId) {
		Card db=dao.fetchById(cardId);
		if(db!=null) {

			ResponseStructure<Card> m=new ResponseStructure<Card>();
			m.setData(db);
			m.setMessage("card found successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Card>>(m,HttpStatus.FOUND);
		}else {
			throw new UserNotFound("card not found....") ;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Card>> updateCard(int cardId,Card card) {
		Card db = dao.fetchById(cardId);
		if (db != null) {
			ResponseStructure<Card> m = new ResponseStructure<Card>();
			m.setData(dao.updateCard(cardId,card));
			m.setMessage("category data fetched successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Card>>(m, HttpStatus.FOUND);
		} else {
			throw new UserNotFound("no card found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Card>> deleteCard(int cardId) {
		Card db = dao.deleteById(cardId);
		if(db!=null) {
		ResponseStructure<Card> s=new ResponseStructure<Card>();
		s.setData(db);
		s.setMessage("card found successfully.........");
		s.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Card>>(s,HttpStatus.FOUND);
		}
		else {
			throw new UserNotFound("card not found for id:"+cardId);
		}
	}

}
