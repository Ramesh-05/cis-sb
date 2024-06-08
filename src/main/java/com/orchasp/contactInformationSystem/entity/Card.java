package com.orchasp.contactInformationSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;
	private String name;
	private String cardType;
	private String designation;
	private long residentialNumber;
	private String email;
	private String offEmail;
	private String offWebsite;
	private String partner;
	private String companyName;
	private String department;
	private long mobileNum;
	private String address;
	private String branches;
	private String category;
}
