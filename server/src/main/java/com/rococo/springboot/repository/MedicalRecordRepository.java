package com.rococo.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.rococo.springboot.model.MedicalRecordModel;

public interface MedicalRecordRepository extends CrudRepository<MedicalRecordModel, Integer>{

}
