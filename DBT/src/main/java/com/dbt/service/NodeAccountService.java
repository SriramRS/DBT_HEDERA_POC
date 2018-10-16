package com.dbt.service;

public interface NodeAccountService {

	public long getAccountBal(String type);
	public String transferCrypto(long amt);
}
