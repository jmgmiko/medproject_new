package com.rococo.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.rococo.springboot.model.PatientModel;

public interface PatientRepository extends CrudRepository<PatientModel, Integer>{

}
