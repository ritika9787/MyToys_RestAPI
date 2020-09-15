package com.myToys.restAPI.consumerData.controller;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.myToys.restAPI.consumerData.service.ProductService;


@Path("/product")
public class ProductAPI {
	
	@GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public String getProductData() throws IOException {
		
		ProductService service = new ProductService();
		return service.getProductData();
	 
	  }
}
