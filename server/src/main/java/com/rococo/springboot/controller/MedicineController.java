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
import com.rococo.springboot.model.MedicineModel;
import com.rococo.springboot.service.MedicineServiceImpl;
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
@RequestMapping("/medicine")
@CrossOrigin(value = "http://localhost:4200/")
public class MedicineController {
    @Autowired
    MedicineServiceImpl medicine;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveUser(@RequestBody MedicineModel given) {
        medicine.registerMedicine(given);
        return "Saved";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@RequestBody MedicineModel given){
        medicine.removeMedicine(given);
        return given.getId()+" deleted";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public MedicineModel findByName(@RequestParam("name") String given){
        return medicine.getByName(given);
    }
       
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<MedicineModel> findAll(){
        return (Collection<MedicineModel>) medicine.getAll();
    }
       
}
