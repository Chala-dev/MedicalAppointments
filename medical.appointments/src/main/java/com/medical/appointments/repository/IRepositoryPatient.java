package com.medical.appointments.repository;

import com.medical.appointments.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryPatient extends JpaRepository<Patient, Integer>{

}
