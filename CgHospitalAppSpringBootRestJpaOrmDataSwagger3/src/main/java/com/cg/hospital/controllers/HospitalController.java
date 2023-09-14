package com.cg.hospital.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.beans.Doctor;
import com.cg.hospital.beans.DoctorList;
import com.cg.hospital.beans.Patient;
import com.cg.hospital.beans.PatientList;
import com.cg.hospital.exceptions.DoctorDetailsNotFoundException;
import com.cg.hospital.exceptions.PatientDetailsNotFoundException;
import com.cg.hospital.services.DoctorService;
import com.cg.hospital.services.PatientService;

@RestController
public class HospitalController{

	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
   
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>("Hello To All Welcome to RestFul WebService",HttpStatus.OK);
	}

	@PostMapping(value =  "/addPatient" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<String> acceptPatientDetails(@ModelAttribute Patient patient){
		patient = patientService.acceptPatientDetails(patient); 
		return new ResponseEntity<String>("Patient details successfuly added id:= "+patient.getId(),HttpStatus.CREATED);
	} 

	@GetMapping(value = "/patientDetailsQueryParam", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> getPatientDetailsQueryParam(int id) throws PatientDetailsNotFoundException{
		return new ResponseEntity<Patient>(patientService.getPatientDetails(id),HttpStatus.OK);
	}

	@GetMapping(value = "/patientDetailsPathVariable/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> getPatientDetailsPathVariable(@PathVariable int  id) throws PatientDetailsNotFoundException{
		return new ResponseEntity<Patient>(patientService.getPatientDetails(id),HttpStatus.OK);
	}

	@GetMapping(value = "/allPatientDetailsJSON", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Patient>> getAllPatientDetailsJSON(){
		return new ResponseEntity<List<Patient>>(patientService.getAllPatientDetails(),HttpStatus.OK);
	}

	@GetMapping(value = "/allPatientDetailsXML", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<PatientList> getAllProductDetailsXML(){
		PatientList patientList = new PatientList(patientService.getAllPatientDetails());
		return new ResponseEntity<PatientList>(patientList,HttpStatus.OK);
	}
	
	@PostMapping(value = "/addBulkPatient", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBulkProductDetails(@RequestBody ArrayList<Patient> patients){
		patientService.acceptBulkPatientsDetails(patients);
		return new ResponseEntity<String>("All patient details sucessfully added ",HttpStatus.OK);
	}
	@DeleteMapping(value = "/removePatientDetails")
	public ResponseEntity<String> removePatientDetails(int patientId) throws PatientDetailsNotFoundException {
		patientService.removePatientDetails(patientId);
		return new ResponseEntity<String>( HttpStatus.OK);
	}

	@PutMapping(value = "/updatePatientDetails")
	public ResponseEntity<String> updatePatientDetails(@ModelAttribute Patient patient) {
		patient = patientService.updatePatientDetails(patient);
		return new ResponseEntity<String>("Patient Details successfully updated Id " + patient.getId(), HttpStatus.CREATED);
		
	}
	
	
	
	
	@PostMapping(value =  "/addDoctor" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<String> acceptDoctorDetails(@ModelAttribute Doctor doctor){
		doctor = doctorService.acceptDoctorDetails(doctor); 
		return new ResponseEntity<String>("Doctor details successfuly added id:= "+doctor.getdId(),HttpStatus.CREATED);
	} 

	@GetMapping(value = "/doctorDetailsQueryParam", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doctor> getDoctorDetailsQueryParam(int id) throws DoctorDetailsNotFoundException{
		return new ResponseEntity<Doctor>(doctorService.getDoctorDetails(id),HttpStatus.OK);
	}

	@GetMapping(value = "/doctorDetailsPathVariable/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doctor> getDoctorDetailsPathVariable(@PathVariable int  id) throws DoctorDetailsNotFoundException{
		return new ResponseEntity<Doctor>(doctorService.getDoctorDetails(id),HttpStatus.OK);
	}

	@GetMapping(value = "/allDoctorDetailsJSON", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Doctor>> getAllDoctorDetailsJSON(){
		return new ResponseEntity<List<Doctor>>(doctorService.getAllDoctorDetails() ,HttpStatus.OK);
	}

	@GetMapping(value = "/allDoctorDetailsXML", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<DoctorList> getAllDoctorDetailsXML(){
		PatientList doctorList = new PatientList(patientService.getAllPatientDetails());
		return new ResponseEntity<DoctorList>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/addBulkDoctor", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBulkDoctorsDetails(@RequestBody ArrayList<Doctor> doctors){
		doctorService.acceptBulkDoctorDetails(doctors);
		return new ResponseEntity<String>("All doctor details sucessfully added ",HttpStatus.OK);
	}
	@DeleteMapping(value = "/removeDoctorDetails")
	public ResponseEntity<String> removeDoctorDetails(int patientId) throws DoctorDetailsNotFoundException {
		doctorService.removeDoctorDetails(patientId);
		return new ResponseEntity<String>( HttpStatus.OK);
	}

	@PutMapping(value = "/updateDoctorDetails")
	public ResponseEntity<String> updateDoctorDetails(@ModelAttribute Doctor doctor) {
		doctor = doctorService.updateDoctorDetails(doctor);
		return new ResponseEntity<String>("Doctor Details successfully updated Id " + doctor.getdId(), HttpStatus.CREATED);
		
	}
}