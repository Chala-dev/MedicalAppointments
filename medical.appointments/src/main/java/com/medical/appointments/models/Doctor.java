package com.medical.appointments.models;

import com.medical.appointments.Enums.StateEnums;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer doctor_id;

    @Column(name = "professional_registration", length = 20, nullable = false)
    private String professional_registration;

    private StateEnums state;

    //Relaciones
    //@OneToMany(mappedBy = "doctor")
    //private List


    public Doctor() {
    }

    public Doctor(Integer doctor_id, String professional_registration, StateEnums state) {
        this.doctor_id = doctor_id;
        this.professional_registration = professional_registration;
        this.state = state;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getProfessional_registration() {
        return professional_registration;
    }

    public void setProfessional_registration(String professional_registration) {
        this.professional_registration = professional_registration;
    }

    public StateEnums getState() {
        return state;
    }

    public void setState(StateEnums state) {
        this.state = state;
    }
}
