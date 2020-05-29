package com.ibm.patient.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibm.patient.model.GetPatientResponse;
import com.ibm.patient.model.Patient;
import com.ibm.patient.service.PatientService;

import io.swagger.annotations.Api;
@RestController
@CrossOrigin(origins="*")
@RequestMapping(value={"/","/patient"})
@Api(value="sample", description="Sample SpringBoot CRUD Application with MongoDB")
public class PatientController {
	@Autowired
	PatientService patientService;

	 @PostMapping(value="/create/patient",headers="Accept=application/json")
	 public ResponseEntity<Void> createPatient(@RequestBody Patient patient, UriComponentsBuilder ucBuilder){
	     patientService.createPatient(patient);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/patient/{name}").buildAndExpand(patient.getName()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get/patient", headers="Accept=application/json")
	 public GetPatientResponse getAllPatient() {		 
		GetPatientResponse patientList = patientService.getAllPatient();
		return patientList;
	 }
	 
	 @GetMapping(value="/get/patient/{id}", headers="accept=application/json")
	 public Optional<Patient> findPatientById(@PathVariable("id") String id){
		 Optional<Patient> patient= patientService.findPatientById(id);
		 return patient;
	 }

	
	  @PutMapping(value="/update/patient/{id}", headers="Accept=application/json") 
	  public ResponseEntity<Patient> updatePatient(@RequestBody Patient currentPatient,@PathVariable("id") String name) {
		  patientService.update(currentPatient, name);
		  return new ResponseEntity<Patient>(HttpStatus.OK); 
	  }
	  
	  @DeleteMapping(value="/delete/patient/{id}", headers ="Accept=application/json") 
	  public ResponseEntity<Patient> deletePatient(@PathVariable("id") String id){
		  Optional<Patient> patient = patientService.findPatientById(id);
		  if (patient == null) { 
			  return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND); 
		  } 
		  patientService.deletePatientById(id);
		  return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT); 
	  }

}
