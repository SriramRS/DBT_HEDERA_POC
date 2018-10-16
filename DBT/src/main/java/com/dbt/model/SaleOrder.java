package com.dbt.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="t_dbt_sale_order")
@Table(name="T_DBT_SALE_ORDER")
public class SaleOrder implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SALE_ID")
    long saleOrdId;
	
	@Column(name="INVOICE_NO")
    String invoiceNo;
	
	@Column(name="RET_NM")
    String retName;
	
	@Column(name="RET_ID")
    String retId;
	
	@OneToOne
	@JoinColumn(name="CUST_ID", referencedColumnName="CUST_ID")
    Customer customer;
	
	@Column(name="OTP")
	long otp;
	
	@Column(name="IS_AUTH")
	@Type(type="yes_no") 
	boolean isAuth=false;	
	
	@Column(name="FARTZ_NM")
	String fartzName;
	
	@Column(name="MANF_NM")
	String manfName;
	
	@Column(name="MANF_ID")
    String manfId;
	
	@Column(name="QTY")
    long qty;
	
	@Column(name="TOTAL_PRICE")
    BigInteger totalPrice;
	
	@Column(name="claimID")
	Long claimId ;
	
	@Column(name="SUB_AMT")
    BigInteger subAmount;

	@Transient
	String status;
	
	public long getSaleOrdId() {
		return saleOrdId;
	}

	public void setSaleOrdId(long saleOrdId) {
		this.saleOrdId = saleOrdId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getRetName() {
		return retName;
	}

	public void setRetName(String retName) {
		this.retName = retName;
	}

	public String getRetId() {
		return retId;
	}

	public void setRetId(String retId) {
		this.retId = retId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getOtp() {
		return otp;
	}

	public void setOtp(long otp) {
		this.otp = otp;
	}

	public boolean isAuth() {
		return isAuth;
	}

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

	public String getFartzName() {
		return fartzName;
	}

	public void setFartzName(String fartzName) {
		this.fartzName = fartzName;
	}

	public String getManfName() {
		return manfName;
	}

	public void setManfName(String manfName) {
		this.manfName = manfName;
	}

	public String getManfId() {
		return manfId;
	}

	public void setManfId(String manfId) {
		this.manfId = manfId;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public BigInteger getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigInteger totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public BigInteger getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(BigInteger subAmount) {
		this.subAmount = subAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 
	

}