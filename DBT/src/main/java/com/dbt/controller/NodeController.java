package com.dbt.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbt.service.NodeAccountService;

@Component
@Path ("/account")

public class NodeController {

	@Autowired
	NodeAccountService nodeAccountService;
	
	@GET
	@Path("/balance/{type}")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public long getAccountBal(@PathParam(value="type") String type) {
		return nodeAccountService.getAccountBal(type);
	}
	
	@GET
	@Path("/transfer/{amt}")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String transferCrypto(@PathParam(value="amt") long amt) {
		return nodeAccountService.transferCrypto(amt);
	}
}
