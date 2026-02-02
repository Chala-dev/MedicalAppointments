package com.medical.appointments.controller;

import com.medical.appointments.models.Patient;
import com.medical.appointments.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")

public class PatientController {
    @Autowired
    PatientService patientServicer;

    @PostMapping
    public ResponseEntity<?> savePatient(@RequestBody Patient data){
        try {
           return ResponseEntity.status(HttpStatus.CREATED).body(this.patientServicer.savePatient(data));
        }catch (Exception error){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> searchAllPatient(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.patientServicer.searchAllPatient());
        }catch (Exception error){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchPatientById(@PathVariable Integer idPatient){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.patientServicer.searchPatientById(idPatient));
        }catch (Exception error){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPatient(@PathVariable Integer idPatient, @RequestBody Patient data){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.patientServicer.editPatient(idPatient, data));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer idPatient){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.patientServicer.deletePatient(idPatient));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

}
