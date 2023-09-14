package com.cg.hospital.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientList {

	@XmlElement(name = "patient")
	private List<Patient> patients;

	public PatientList() {
		// TODO Auto-generated constructor stub
	}
	public PatientList(List<Patient> patients) {
		super();
		this.patients = patients;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patients == null) ? 0 : patients.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientList other = (PatientList) obj;
		if (patients == null) {
			if (other.patients != null)
				return false;
		} else if (!patients.equals(other.patients))
			return false;
		return true;
	}


}
