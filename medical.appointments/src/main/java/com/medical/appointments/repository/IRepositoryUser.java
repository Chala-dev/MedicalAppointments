package com.medical.appointments.repository;

import com.medical.appointments.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryUser extends JpaRepository<User, Integer> {

}
