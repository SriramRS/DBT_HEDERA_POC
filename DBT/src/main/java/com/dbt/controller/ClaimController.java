package com.dbt.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbt.dao.ClaimRepository;
import com.dbt.dao.CustomerRepository;
import com.dbt.dao.SaleOrderRepository;
import com.dbt.model.ClaimVO;
import com.dbt.model.Customer;
import com.dbt.model.SaleOrder;
import com.dbt.service.ClaimDataService;

@Component
@Path("/claim")
public class ClaimController {

	@Autowired
	ClaimDataService claimDataService;
	
	@GET
	@Path("/getClaimedData/{claimId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClaimVO getClaimedData(@PathParam (value="claimId")long claimId){
		ClaimVO claimData=claimDataService.getClaimData(claimId);
		return claimData ;
	}
	
	@GET
	@Path("/getCustomerData/{custDI}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerData(@PathParam (value="custDI")long custDI) {
		return claimDataService.getCustomerData(custDI);
	}
	
	
	@GET
	@Path("/saleOrderData/{manfId}")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<SaleOrder> orderDataForClaim(@PathParam (value="manfId")String manfId) {
		return claimDataService.orderDataForClaim(manfId);
	}
	
	@GET
	@Path("/viewSaleOrder/{saleId}")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public SaleOrder viewOrderDataForClaim(@PathParam (value="saleId")long saleId) {
		return claimDataService.viewOrderDataForClaim(saleId);
	}
	
	@POST
	@Path("/updateClaim")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String updateClaim(@RequestBody SaleOrder saleOrder) {
		return claimDataService.updateClaim(saleOrder);
	}
	
	@POST
	@Path("/updateProcessClaim")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String updateProcessedClaim(@RequestBody ClaimVO claimVO) {
		return claimDataService.updateProcessClaim(claimVO);
	}

	
	@GET
	@Path("/viewAllClaims/{status}")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	
	public List<ClaimVO> viewClaimDataByStatus(@PathParam (value="status")String  status) {
		return claimDataService.viewClaimDataByStatus(status);
	}
	
	
}
