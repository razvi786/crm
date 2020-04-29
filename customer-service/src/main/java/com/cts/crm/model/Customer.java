package com.cts.crm.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	private String name;
	private String mobileNumber;
	private String email;
	private String circle;
	private String dp;	
}
