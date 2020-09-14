package com.myToys.restAPI.consumerData.utils.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.myToys.restAPI.consumerData.dto.Product;
import com.myToys.restAPI.consumerData.utils.AbstractCsvToJson;

public class ProductCsvToJson extends AbstractCsvToJson {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> mapCSVToObject(Stream<String> fileDataStream) {
		Pattern pattern = Pattern.compile(",");
	    List<Product> productList = new ArrayList<Product>();

	    productList = (List<Product>) fileDataStream.map(line -> { 
	    	    String[] x = pattern.split(line); 
	    	    return new Product(Integer.parseInt(x[0]), x[1], new Double(x[2]), 
	    	    		new Double(x[3]), Integer.parseInt(x[4]), x[5]); })
	    		  
	    		  .collect(Collectors.toList());

	    return (List<T>) productList ;
	}	
}
