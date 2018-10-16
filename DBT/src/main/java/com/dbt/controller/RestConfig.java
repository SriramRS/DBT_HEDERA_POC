package com.dbt.controller;




import javax.ws.rs.ApplicationPath;


import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.dbt.controller.ClaimController;
import com.dbt.controller.SaleOrderController;






@Component
@ApplicationPath("/api")
public class RestConfig extends ResourceConfig {
	public RestConfig() {		
		this.register(JacksonFeature.class);	
		this.register(ClaimController.class);
		this.register(NodeController.class);

		this.register(SaleOrderController.class);
		this.register(CORSFilter.class);
		}
}
