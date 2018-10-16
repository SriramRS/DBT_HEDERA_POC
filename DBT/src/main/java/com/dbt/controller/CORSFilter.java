package com.dbt.controller;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.PreMatching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



public class CORSFilter implements ContainerResponseFilter  {
    private static final Logger LOGGER = LoggerFactory.getLogger(CORSFilter.class);
   @Override
   public void filter(ContainerRequestContext request,
           ContainerResponseContext response) throws IOException {
       LOGGER.info("Initializing the Cors FILTER....");
       response.getHeaders().add("Access-Control-Allow-Origin", "*");
       response.getHeaders().add("Access-Control-Allow-Headers",
               "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
       response.getHeaders().add("Access-Control-Allow-Credentials", "true");
       response.getHeaders().add("Access-Control-Allow-Methods",
               "GET, POST, PUT, DELETE, OPTIONS, HEAD, , X-XSRF-TOKEN");
    response.getHeaders().add("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate, max-age=0");
   }
}