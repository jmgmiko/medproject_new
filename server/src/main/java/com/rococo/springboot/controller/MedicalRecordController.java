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
import com.rococo.springboot.model.MedicalRecordModel;
import com.rococo.springboot.model.MedicineModel;
import com.rococo.springboot.service.MedicalRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
 
@RestController
@RequestMapping("/medrecord")
@CrossOrigin(value = "http://localhost:4200/")
public class MedicalRecordController {
    @Autowired
    MedicalRecordServiceImpl medicine;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveRecord(@RequestBody MedicalRecordModel given) {
        medicine.registerMedicine(given);
        return "Saved";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateRecord(@RequestBody MedicalRecordModel given) {
        medicine.updateMedicine(given);
        return "Updated";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@RequestBody MedicalRecordModel given){
        medicine.removeMedicalRecordInfo(given);
        return given.getId()+" deleted";
    }
       
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<MedicalRecordModel> findAll(){
        return (Collection<MedicalRecordModel>) medicine.getAll();
    }
       
}
