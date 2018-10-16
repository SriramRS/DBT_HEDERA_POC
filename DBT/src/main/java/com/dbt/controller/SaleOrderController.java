package com.dbt.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.ws.Response;

import org.codehaus.plexus.component.annotations.Component;
import org.hibernate.annotations.Where;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbt.dao.ClaimRepository;
import com.dbt.dao.CustomerRepository;
import com.dbt.dao.SaleOrderRepository;
import com.dbt.model.ClaimVO;
import com.dbt.model.Customer;
import com.dbt.model.SaleOrder;
import com.dbt.service.ClaimDataService;
import com.dbt.service.SaleOrderService;

@org.springframework.stereotype.Component
@Path("/order")
public class SaleOrderController {


	@Autowired
	SaleOrderService saleOrderService;
	
	@Autowired
	private CustomerRepository  customerRepository;
	
	
	@POST
	@Path("/putSaleOrder")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String putSaleData(@RequestBody SaleOrder saleOrder){
		return saleOrderService.persistSaleOrder(saleOrder);
	}

	
	@GET
	@Path("/customerData/{customerId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Customer getCustomerData(@PathParam (value="customerId")long custDI) {
		Customer customer=(Customer)customerRepository.findById(custDI).get();
		return customer ;
	}
	
}
