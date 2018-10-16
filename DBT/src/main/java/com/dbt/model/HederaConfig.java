package com.dbt.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="hedera")
@Table(name="T_DBT_HEDERA_CONFIG")
public class HederaConfig {

	@EmbeddedId
	HederaConfigPrky prKy;
	
	@Column(name="PUB_KEY")
	byte[] pubKey;
	
	@Column(name="PRI_KEY")
	byte[] priKey;
	
	@Column(name="SEC")
	long sec;
	
	@Column(name="NANO")
	long nano;
	
	@Column(name="TYPE")
	String type;

	public HederaConfigPrky getPrKy() {
		return prKy;
	}

	public void setPrKy(HederaConfigPrky prKy) {
		this.prKy = prKy;
	}

	public byte[] getPubKey() {
		return pubKey;
	}

	public void setPubKey(byte[] pubKey) {
		this.pubKey = pubKey;
	}

	public byte[] getPriKey() {
		return priKey;
	}

	public void setPriKey(byte[] priKey) {
		this.priKey = priKey;
	}

	public long getSec() {
		return sec;
	}

	public void setSec(long sec) {
		this.sec = sec;
	}

	public long getNano() {
		return nano;
	}

	public void setNano(long nano) {
		this.nano = nano;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
