package com.medical.appointments.service;

import com.medical.appointments.models.Patient;
import com.medical.appointments.repository.IRepositoryPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    IRepositoryPatient repositoryPatient;

    //Guardar
    public Patient savePatient (Patient data) throws Exception{
        try {
            return this.repositoryPatient.save(data);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar Todos
    public List<Patient> searchAllPatient() throws Exception{
        try {
            return this.repositoryPatient.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Patient searchPatientById(Integer idPatient) throws Exception{
        try {
            Optional<Patient> wantedPatient = this.repositoryPatient.findById(idPatient);
            if (wantedPatient.isPresent()){
                return wantedPatient.get();
            }else {
                throw new Exception("The patient you are looking for is not in the database.");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Modificar Por ID

    public Patient editPatient(Integer idPatient, Patient data) throws Exception {
        try {
            Optional<Patient> wantedPatient = this.repositoryPatient.findById(idPatient);
            if (wantedPatient.isPresent()) {
                wantedPatient.get().setId_patient(data.getId_patient());
                wantedPatient.get().setIdentity_document(data.getIdentity_document());
                wantedPatient.get().setDate_birth(data.getDate_birth());
                return this.repositoryPatient.save(wantedPatient.get());
            } else {
                throw new Exception("The patient you are looking for is not in the database.");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar

    public boolean deletePatient (Integer idPatient) throws Exception{
        try {
            Optional<Patient> wantedPatient = this.repositoryPatient.findById(idPatient);
            if (wantedPatient.isPresent()){
                this.repositoryPatient.deleteById(idPatient);
                return true;
            }else {
                throw new Exception("The patient you are looking for is not in the database.");
            }
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}


