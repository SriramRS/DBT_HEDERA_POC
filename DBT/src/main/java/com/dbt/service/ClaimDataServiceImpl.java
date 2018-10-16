package com.dbt.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dbt.dao.ClaimRepository;
import com.dbt.dao.CustomerRepository;
import com.dbt.dao.SaleOrderRepository;
import com.dbt.model.ClaimVO;
import com.dbt.model.Customer;
import com.dbt.model.SaleOrder;

@Service
public class ClaimDataServiceImpl implements ClaimDataService{

	@Autowired
	private SaleOrderRepository saleOrderRepository;
	
	@Autowired
	private ClaimRepository claimRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<ClaimVO> loadClaimData() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer getCustomerData(long custDI) {
		// TODO Auto-generated method stub
		return customerRepository.findById(custDI).get();
	}

	@Override
	public List<SaleOrder> orderDataForClaim(String manfId) {
		// TODO Auto-generated method stub
		List<SaleOrder> saleData=saleOrderRepository.findAllByManfId(manfId);
		return saleData ;
	}

	@Override
	public SaleOrder viewOrderDataForClaim(long saleId) {
		// TODO Auto-generated method stub
		SaleOrder saleData=saleOrderRepository.findById(saleId).get();
	    //Customer customer=customerRepository.findById(saleData.get);
		return saleData ;
	
	}

	@Override
	public String updateClaim(SaleOrder saleOrder) {
		
		ClaimVO claimVo=new ClaimVO();
		claimVo.setManufactName(saleOrder.getManfName());
		claimVo.setManufactID(saleOrder.getManfId());
		claimVo.setStatus(saleOrder.getStatus());
		claimVo.setTotalSubAmt(saleOrder.getSubAmount());
		claimVo=claimRepository.save(claimVo);
		saleOrder.setClaimId(claimVo.getClaimID());
		saleOrderRepository.save(saleOrder);
		// TODO Auto-generated method stub
		return "success";
	}
	
	public List<ClaimVO> getClaimedData(String status){	
		
		return claimRepository.findAllByStaus(status);
		
		
		
	}
	public  ClaimVO getClaimData(long  claimId) {
		return claimRepository.findById(claimId).get();
	
		
	}


	@Override
	public String updateProcessClaim(ClaimVO claim) {
		claim=claimRepository.save(claim);
		// TODO Auto-generated method stub
		return "Success";
	}


	@Override
	public List<ClaimVO> viewClaimDataByStatus(String status) {
		// TODO Auto-generated method stub
		return claimRepository.findAllByStaus(status);
	}
	
	

	
	
	
	
	
	
	

}
