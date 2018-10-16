package com.dbt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbt.hedera.utilities.HederaHelper;

@Service
public class NodeAccountServiceImpl  implements NodeAccountService{

@Autowired
HederaHelper hederaHelper;

	@Override
	public long getAccountBal(String type) {
		// TODO Auto-generated method stub
		return hederaHelper.getAccountBal(type);
	}

	@Override
	public String transferCrypto(long amt) {
		// TODO Auto-generated method stub
		hederaHelper.transferCrypto(amt);
		return "Success";
	}
}
