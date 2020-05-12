package com.ibm.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.patient.model.GetPatientResponse;
import com.ibm.patient.model.Patient;
import com.ibm.patient.repository.PatientRepository;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	public void createPatient(Patient patient) {

		patientRepository.save(patient);
	}

	public GetPatientResponse getAllPatient() {

		GetPatientResponse patietData = new GetPatientResponse();
		patietData.setPatients((List<Patient>) patientRepository.findAll());
		return patietData;
	}

	public Optional<Patient> findPatientById(String id) {
		return patientRepository.findById(id);
	}

	public void update(Patient newPatient, String id) {

		Optional<Patient> patient = patientRepository.findById(id);
		Patient ptn = new Patient();
		if (patient != null && patient.isPresent()) {
			ptn.setName(newPatient.getName());
			ptn.setMobile(newPatient.getMobile());
			ptn.setId(newPatient.getId());
			patientRepository.save(ptn);
		}

	}

	public void deletePatientById(String id) {
		patientRepository.deleteById(id);
	}

}
