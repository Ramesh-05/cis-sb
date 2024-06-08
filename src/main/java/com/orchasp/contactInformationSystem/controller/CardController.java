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

import com.orchasp.contactInformationSystem.dao.CardDaoImpl;
import com.orchasp.contactInformationSystem.entity.Card;
import com.orchasp.contactInformationSystem.service.CardServiceImpl;
import com.orchasp.contactInformationSystem.util.ResponseStructure;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/card")
@RestController
public class CardController {
	
	@Autowired
	private CardServiceImpl cardserv;
	@Autowired
	private CardDaoImpl dao;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Card>> saveCard(@RequestBody Card card){
		return cardserv.saveCard(card);
	}
	@GetMapping("/fetch/{cardId}")
	public Card fetchCard(@PathVariable int cardId){
		return dao.fetchById(cardId);
	}
	@PutMapping("/update/{cardId}")
	public ResponseEntity<ResponseStructure<Card>> updateCard(@PathVariable int cardId, @RequestBody Card card){
		return cardserv.updateCard(cardId,card);
	}
	@DeleteMapping("/delete/{cardId}")
	public ResponseEntity<ResponseStructure<Card>> deleteCard(@PathVariable int cardId){
		return cardserv.deleteCard(cardId);
	}
	
	@GetMapping("/fetchall")
	public List<Card> fetchAll() {
		return dao.fetchAll();
	}



}
