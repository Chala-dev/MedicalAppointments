package com.medical.appointments.service;

import com.medical.appointments.models.Doctor;
import com.medical.appointments.repository.IRepositoryDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    IRepositoryDoctor repositoryDoctor;

    //guardar

    public Doctor saveDoctor(Doctor data) throws Exception{
        try {
            return this.repositoryDoctor.save(data);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Doctor> searchAllDoctor() throws Exception{
        try {
            return this.repositoryDoctor.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
