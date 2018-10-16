package com.dbt.service;

import java.util.List;


import com.dbt.model.ClaimVO;
import com.dbt.model.Customer;
import com.dbt.model.SaleOrder;

public interface  ClaimDataService {

	public List<ClaimVO> loadClaimData();
	
	public List<ClaimVO> getClaimedData(String status);
	public  ClaimVO getClaimData(long  claimId);
	
	public Customer getCustomerData(long custDI) ;
	
	
	public List<SaleOrder> orderDataForClaim(String manfId);
	
	public	SaleOrder viewOrderDataForClaim(long saleId);
	
	public	String updateClaim (SaleOrder saleOrder);
	
	public	String updateProcessClaim (ClaimVO claim);
	
	public List<ClaimVO> viewClaimDataByStatus(String status);
	
	

}
