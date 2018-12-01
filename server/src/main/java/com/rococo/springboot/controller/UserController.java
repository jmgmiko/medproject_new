/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rococo.springboot.controller;

/**
 *
 * @author staff
 */
import com.rococo.springboot.model.User;
import com.rococo.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.Collections;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
 
@RestController
@RequestMapping("/user")
@CrossOrigin(value = "http://localhost:4200/")
public class UserController {
    @Autowired
    UserServiceImpl medicine;
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@RequestBody User given) {
        return "Saved";
    }
       
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<User> findAll(){
        return (Collection<User>) medicine.getAll();
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(@RequestBody User given) {
        medicine.registerPerson(given);
        return "Saved";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)    
    public User findUser (@RequestBody User given) {
        return medicine.getPersonByUsernamePassword(given.getUsername(), given.getPassword());
    }
       
}
