package com.medical.appointments.service;

import com.medical.appointments.models.User;
import com.medical.appointments.repository.IRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IRepositoryUser userRepository;

    public boolean saveUser (User data) throws Exception {
        try {
            this.userRepository.save(data);
            return true;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<User> searchAllUser () throws Exception {
        try {
            return this.userRepository.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

}