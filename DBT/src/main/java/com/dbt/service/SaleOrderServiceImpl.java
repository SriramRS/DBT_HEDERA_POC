package com.dbt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbt.dao.SaleOrderRepository;
import com.dbt.model.ClaimVO;
import com.dbt.model.SaleOrder;

@Service
public class  SaleOrderServiceImpl implements SaleOrderService {

	@Autowired
	SaleOrderRepository saleOrderRepository;
	
	@Override
	public String persistSaleOrder(SaleOrder saleOrder) {
		
		// TODO Auto-generated method stub
		
		SaleOrder saleOrderDB =saleOrderRepository.save(saleOrder);
		if (null!=saleOrderDB) {
			return "Sucess";
		}else {
			return "Error";
		}
		
	}

	@Override
	public List<SaleOrder> getSaleOrderData() {
		// TODO Auto-generated method stub
		return saleOrderRepository.findAll();
	}


}
