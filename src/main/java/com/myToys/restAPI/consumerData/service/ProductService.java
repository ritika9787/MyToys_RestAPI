package com.myToys.restAPI.consumerData.service;

import java.io.IOException;

import com.myToys.restAPI.consumerData.repository.impl.ProductCsvToJson;
import com.myToys.restAPI.consumerData.utils.Constants;

public class ProductService {
	
	public String getProductData() throws IOException {
	    
		ProductCsvToJson mapper = new ProductCsvToJson();	   	    
	    return mapper.getJSONResponse(getClass().getResource(Constants.PRODUCT_FILE_PATH).getPath());
		 
	}
	
}
