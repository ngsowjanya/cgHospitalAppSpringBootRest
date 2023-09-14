package com.cg.hospital.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DoctorList {

	@XmlElement(name = "doctor")
	private List<Doctor> doctors;

	public DoctorList() {
		// TODO Auto-generated constructor stub
	}
	public DoctorList(List<Doctor> doctors) {
		super();
		this.doctors = doctors;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctors == null) ? 0 : doctors.hashCode());
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
		DoctorList other = (DoctorList) obj;
		if (doctors == null) {
			if (other.doctors != null)
				return false;
		} else if (!doctors.equals(other.doctors))
			return false;
		return true;
	}


}
