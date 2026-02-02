package com.medical.appointments.models;

import com.medical.appointments.Enums.StateEnums;
import com.medical.appointments.Enums.UserEnums;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String email;
    @Column(length = 200, nullable = false)
    private String password;
    private UserEnums role;
    private StateEnums state;
    private Date date_creation;

    //RELACIONES
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Patient patient;
    public User() {
    }

    public User(Integer id_user, String name, String email, String password, UserEnums role, StateEnums state, Date date_creation, Patient patient) {
        this.id_user = id_user;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.state = state;
        this.date_creation = date_creation;
        this.patient = patient;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEnums getRole() {
        return role;
    }

    public void setRole(UserEnums role) {
        this.role = role;
    }

    public StateEnums getState() {
        return state;
    }

    public void setState(StateEnums state) {
        this.state = state;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
