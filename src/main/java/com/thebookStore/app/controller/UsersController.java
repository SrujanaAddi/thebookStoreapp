package com.thebookStore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thebookStore.app.entity.Users;
import com.thebookStore.app.exception.UsersException;
import com.thebookStore.app.service.UserService;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/user")
    public Users addUser(@Valid @RequestBody Users user) {
        return userService.addUser(user);
        
    }
    @PutMapping("/user")
    public Users UserServiceUpdate(@Valid @RequestBody Users user) throws UsersException  {
        return userService.updateUser(user);
    }
    @DeleteMapping("/user/{userId}")
    public Users userServiceRemove(@PathVariable("userId") Integer usersId) throws UsersException {
        return userService.removeUser(usersId);
    }
    
    @GetMapping("/allUsers")
    public List<Users> getUsers() {
        return userService.showAllUsers();
    }
    
    @GetMapping("/User/{id}")
    public Users getUserById(@PathVariable("id") Integer userId) throws UsersException{
        return userService.getUserByUserID(userId);
    }


}
