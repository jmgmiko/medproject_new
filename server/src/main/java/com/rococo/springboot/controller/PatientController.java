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
import com.rococo.springboot.model.PatientModel;
import com.rococo.springboot.service.PatientServiceImpl;
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
@RequestMapping("/patient")
@CrossOrigin(value = "http://localhost:4200/")
public class PatientController {
    @Autowired
    PatientServiceImpl medicine;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveUser(@RequestBody PatientModel given) {
        medicine.registerPatient(given);
        return "Saved";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@RequestBody PatientModel given){
        medicine.removePatientById(given);
        return given.getId()+" deleted";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public PatientModel findPatientById(@RequestParam("id") int given){
        return medicine.getPatientInfo(given);
    }
       
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<PatientModel> findAll(){
        return (Collection<PatientModel>) medicine.getAll();
    }
       
}
