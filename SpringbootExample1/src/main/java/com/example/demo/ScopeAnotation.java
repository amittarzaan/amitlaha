package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class ScopeAnotation {
	private int id;
	private String name;
	ScopeAnotation(){
		System.out.println("ScopeAnotation is initialied");
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
	
	public void show() {
		System.out.println("This is a show method of ScopeAnotation");
	}

}
