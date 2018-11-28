package com.rococo.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.rococo.springboot.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientModel, Integer>{

}
