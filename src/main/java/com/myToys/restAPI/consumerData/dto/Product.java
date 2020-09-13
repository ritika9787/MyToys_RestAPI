package com.myToys.restAPI.consumerData.dto;

public class Product {
	
	private int id;
	private String name;
	private Double price;
	private Double old_price;
	private int stock;
	private String brand;
	
	
	
	public Product() {
		
	}


	public Product(int id, String name, Double price, Double old_price, int stock, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.old_price = old_price;
		this.stock = stock;
		this.brand = brand;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getOld_price() {
		return old_price;
	}


	public void setOld_price(Double old_price) {
		this.old_price = old_price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}	

}
