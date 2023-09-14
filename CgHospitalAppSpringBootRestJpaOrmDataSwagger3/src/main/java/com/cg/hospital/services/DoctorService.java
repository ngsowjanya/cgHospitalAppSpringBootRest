package com.cg.hospital.services;

import java.util.List;

import com.cg.hospital.beans.Doctor;
import com.cg.hospital.exceptions.DoctorDetailsNotFoundException;


public interface DoctorService {

	public Doctor acceptDoctorDetails(Doctor doctor);
	public List<Doctor> getAllDoctorDetails();
	public Doctor getDoctorDetails(int id)throws DoctorDetailsNotFoundException;
	public void acceptBulkDoctorDetails(List<Doctor> doctor);
	public boolean removeDoctorDetails(int id);
	public Doctor updateDoctorDetails(Doctor doctor);
}
