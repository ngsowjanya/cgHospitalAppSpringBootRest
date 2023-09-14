package com.cg.hospital.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.beans.Doctor;



public interface DoctorDao extends JpaRepository<Doctor, Integer>{

}
