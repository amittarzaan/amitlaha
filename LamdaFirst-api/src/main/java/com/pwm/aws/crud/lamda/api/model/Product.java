package com.pwm.aws.crud.lamda.api.model;

import com.google.gson.Gson;

public class Product {
	private int id;
	private String name;
	private double price;
	
	public Product(int id,String name,double price) {
		this.id=id;
		this.name=name;
		this.price=price;
	}
	
	public Product(String jsonString) {
		Gson gson=new Gson();
		Product tempProduct=gson.fromJson(jsonString, Product.class);
		this.id=tempProduct.id;
		this.name=tempProduct.name;
		this.price=tempProduct.price;		
	}
	public String toString() {
		return new Gson().toJson(this);
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
