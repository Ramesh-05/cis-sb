package com.orchasp.contactInformationSystem.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String orgCode;
	private String place;
	private long   phoneNum;
	private String email;
	private String dateOfReg;
	private String cstNo;
	private String ceCode;
	private String drclNo;
	private String panGir;
	private String eximCode;
	private String gstRate;
	private String orgName;
	private String address1;
	private String address2;
	private long   pincode;
	private String teleEx;
	private String grams;
	private String regNo;
	private String inceptionDate;
	private String gstNo;
	private String cerNo;
	private String fromDate;
	private String tdsAccount;
	private String panExt;
	private String cstRate;
	private String exciseDutyRate;
	private String logo;
}
