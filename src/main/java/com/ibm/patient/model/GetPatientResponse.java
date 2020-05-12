package com.ibm.patient.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetPatientResponse {
	  
	 @JsonProperty("patients")
	  private List<Patient> patients = new ArrayList<Patient>();

	  public GetPatientResponse patients(List<Patient> patients) {
	    this.patients = patients;
	    return this;
	  }

	  public GetPatientResponse addPatients(Patient patient) {
	    this.patients.add(patient);
	    return this;
	  }

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	  
	  

}
