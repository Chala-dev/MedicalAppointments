package com.medical.appointments.repository;

import com.medical.appointments.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryDoctor extends JpaRepository<Doctor, Integer>{

}
