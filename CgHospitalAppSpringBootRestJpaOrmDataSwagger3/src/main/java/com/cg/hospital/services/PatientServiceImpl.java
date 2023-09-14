package com.cg.hospital.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.hospital.beans.Patient;
import com.cg.hospital.daos.PatientDAO;
import com.cg.hospital.exceptions.PatientDetailsNotFoundException;

@Component(value = "productService")
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	public Patient acceptPatientDetails(Patient patient) {
		return patientDAO.save(patient);
	}

	@Override
	public List<Patient> getAllPatientDetails() {
		return patientDAO.findAll();
	}

	@Override
	public Patient getPatientDetails(int productId) throws PatientDetailsNotFoundException {
		return patientDAO.findById(productId).orElseThrow(()->new PatientDetailsNotFoundException("Product details not found for id	"+productId));
	}

	@Override
	public void acceptBulkPatientsDetails(List<Patient> patients) {
		for (Patient patient : patients) 
			patientDAO.save(patient);
	}

	@Override
	public void removePatientDetails(int patientId) {
		patientDAO.deleteById(patientId);
	}

	@Override
	public Patient updatePatientDetails(Patient patient) {
		int id = patient.getId();
		Optional<Patient> pat = Optional.of(patientDAO.getById(id));
		Patient patient2 = null;
		try {
			patient2 = pat.orElseThrow(() -> new PatientDetailsNotFoundException("Patient not found"));
		} catch (PatientDetailsNotFoundException e) {
			e.printStackTrace();
		}
		patient2.setId(patient.getId());
		patient2.setpAddress(patient.getpAddress());
		patient2.setpAge(patient.getpAge());
		patient2.setpGender(patient.getpGender());
		patient2.setpName(patient.getpName());
		
		return patientDAO.save(patient2);
	}

}
