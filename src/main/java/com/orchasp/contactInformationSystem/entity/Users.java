package com.orchasp.contactInformationSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberId;
	private String password;
	private String email;
	private long mobileNumber;
	private String contactAddress;
	private String confirmPassword;
	private String name;
	private String telephoneNumber;
}
