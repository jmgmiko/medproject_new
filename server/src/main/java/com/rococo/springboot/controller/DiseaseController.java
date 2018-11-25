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
import com.rococo.springboot.model.DiseaseModel;
import com.rococo.springboot.service.DiseaseServiceImpl;
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
@RequestMapping("/disease")
@CrossOrigin(value = "http://localhost:4200/")
public class DiseaseController {
    @Autowired
    DiseaseServiceImpl medicine;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveDisease(@RequestBody DiseaseModel given) {
        medicine.registerMedicine(given);
        return "Saved";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateDisease(@RequestBody DiseaseModel given) {
        medicine.registerMedicine(given);
        return "Updated";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@RequestBody DiseaseModel given){
        medicine.removeMedicine(given);
        return given.getId()+" deleted";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public DiseaseModel findByName(@RequestParam("name") String given){
        return medicine.getDiseaseByName(given);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public DiseaseModel findById(@RequestParam("id") int given){
        return medicine.getDiseaseById(given);
    }
       
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<DiseaseModel> findAll(){
        return (Collection<DiseaseModel>) medicine.getAll();
    }
       
}
