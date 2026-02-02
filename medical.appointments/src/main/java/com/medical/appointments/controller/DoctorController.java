package com.medical.appointments.controller;

import com.medical.appointments.models.Doctor;
import com.medical.appointments.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/doctors/")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping
    public ResponseEntity<?> saveDoctor(@RequestBody Doctor data){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.doctorService.saveDoctor(data));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> searchAllDoctor(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.doctorService.searchAllDoctor());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

}