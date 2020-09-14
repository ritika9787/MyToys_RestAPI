package com.myToys.restAPI.consumerData.service;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.myToys.restAPI.consumerData.utils.Constants;
import com.myToys.restAPI.consumerData.utils.impl.ProductCsvToJson;

@Path("/product")
public class ProductAPI {
	
	@GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public String getProductData() throws IOException {
	    
		ProductCsvToJson mapper = new ProductCsvToJson();	   	    
	    return mapper.getJSONResponse(getClass().getResource(Constants.PRODUCT_FILE_PATH).getPath());
	 
	}
}
