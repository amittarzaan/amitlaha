package com.ibm.patient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.patient.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

}
