package com.myToys.restAPI.consumerData;

import java.io.IOException;

import com.myToys.restAPI.consumerData.service.ProductAPI;

public class App{
	
	public static void main(String args[]) throws IOException {
		
		ProductAPI productAPI = new ProductAPI();
		System.out.println(productAPI.getProductData());
	}
}