package com.dbt.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="claim")
@Table(name="T_DBT_CLAIM_DATA")
public class ClaimVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLAIM_ID")
	Long claimID;
	
	@Column(name="MANUFC_NM")
	String manufactName;
	
	@Column(name="MANUFC_ID")
	String manufactID;
	
	@Column(name="TOTAL_SUB_AMT")
	BigInteger totalSubAmt;

	@Column(name="status")
	String status;

	public Long getClaimID() {
		return claimID;
	}


	public void setClaimID(Long claimID) {
		this.claimID = claimID;
	}


	public String getManufactName() {
		return manufactName;
	}


	public void setManufactName(String manufactName) {
		this.manufactName = manufactName;
	}


	public BigInteger getTotalSubAmt() {
		return totalSubAmt;
	}


	public void setTotalSubAmt(BigInteger totalSubAmt) {
		this.totalSubAmt = totalSubAmt;
	}


	public String getManufactID() {
		return manufactID;
	}


	public void setManufactID(String manufactID) {
		this.manufactID = manufactID;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

}
