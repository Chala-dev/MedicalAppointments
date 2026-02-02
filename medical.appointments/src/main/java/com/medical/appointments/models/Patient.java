package com.medical.appointments.models;
import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.Date;
@Entity
@Table(name = "patient")

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_patient;
    @Column(name = "identity_document", length = 50, nullable = false)
    private BigInteger identity_document;
    private Date date_birth;

    //RELACIONES
    @OneToOne
    @JoinColumn(name = "id_user", nullable = false, unique = true)
    private User user;

    public Patient() {
    }

    public Patient(Integer id_patient, BigInteger identity_document, Date date_birth, User user) {
        this.id_patient = id_patient;
        this.identity_document = identity_document;
        this.date_birth = date_birth;
        this.user = user;
    }

    public Integer getId_patient() {
        return id_patient;
    }

    public void setId_patient(Integer id_patient) {
        this.id_patient = id_patient;
    }

    public BigInteger getIdentity_document() {
        return identity_document;
    }

    public void setIdentity_document(BigInteger identity_document) {
        this.identity_document = identity_document;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
