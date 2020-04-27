package com.cts.crm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	private String name;
	private String mobileNumber;
	private String email;
	private String circle;
	private String dp;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getDp() {
		return dp;
	}
	public void setDp(String dp) {
		this.dp = dp;
	}
	public Customer(int customerId, String name, String mobileNumber, String email, String circle, String dp) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.circle = circle;
		this.dp = dp;
	}
	public Customer() {
		super();
	}
	
	
}
