package com.dbt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_DBT_CUSTOMER")
public class Customer  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUST_ID")
	Long customerId;
	
	@Column(name="CUST_NM")
	String customerNm;
	

	@Column(name="ADDRESS")
	String location;
	

	@Column(name="CONTACT")
	String contactNumber;
	

	@Column(name="LAND_AREA")
	long landArea;


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerNm() {
		return customerNm;
	}


	public void setCustomerNm(String customerNm) {
		this.customerNm = customerNm;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public long getLandArea() {
		return landArea;
	}


	public void setLandArea(long landArea) {
		this.landArea = landArea;
	}


	
	
}
