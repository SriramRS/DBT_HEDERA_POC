package com.dbt.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbt.model.SaleOrder;


public interface  SaleOrderService {


	public String persistSaleOrder(SaleOrder saleOrder);
	public List<SaleOrder>getSaleOrderData();
}
