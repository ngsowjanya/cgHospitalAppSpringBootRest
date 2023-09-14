package com.cg.hospital.daos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.beans.Patient;
public interface PatientDAO extends JpaRepository<Patient, Integer>{
	
}