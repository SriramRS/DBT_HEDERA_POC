package com.dbt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HederaConfigPrky implements Serializable {

    @Column(name="ACC_NM")
	long accNum;
    
    @Column(name="SHARD")
	long shard;
    
    @Column(name="REALM")
	long realm;
    
    
    
    public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public long getShard() {
		return shard;
	}
	public void setShard(long shard) {
		this.shard = shard;
	}
	public long getRealm() {
		return realm;
	}
	public void setRealm(long realm) {
		this.realm = realm;
	}
	
	
	
}
