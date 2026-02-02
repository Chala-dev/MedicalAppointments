package com.medical.appointments.controller;

import com.medical.appointments.models.User;
import com.medical.appointments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    //Guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody User data){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUser(data));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //BuscarTodos
    @GetMapping
    public ResponseEntity<?> searchAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.searchAllUser());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


}
