package com.orchasp.contactInformationSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	private String companyName;
	private String city;
	private long pincode;
	private String webAddress;
	private String active;
	private String address;
	private String state;
	private long contactNumber;
	private String email;
}
