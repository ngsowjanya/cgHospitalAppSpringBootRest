package com.cg.hospital.services;
import java.util.List;

import com.cg.hospital.beans.Patient;
import com.cg.hospital.exceptions.PatientDetailsNotFoundException;
public interface PatientService {
	public Patient acceptPatientDetails(Patient patient);
	public List<Patient> getAllPatientDetails();
	public Patient getPatientDetails(int productId)throws PatientDetailsNotFoundException;
	public void acceptBulkPatientsDetails(List<Patient> patients);
	public void removePatientDetails(int patientId);
	public Patient updatePatientDetails(Patient patient);
}