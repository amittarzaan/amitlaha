package com.ibm.patient.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "patients")
public class Patient {

	@Id //It denotes that this is primary key
	@Field(value = "_id")  //It maps JSON property with MongoDB Document Field
	private String id;
	private String mobile;
	private String name;

	/*Constructors*/
	public Patient() {

	}

	public Patient(String id, String name, String mobile) {

		this.id = id;
		this.name = name;
		this.mobile = mobile;
	}

	
	/* Getters and Setters*/
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
