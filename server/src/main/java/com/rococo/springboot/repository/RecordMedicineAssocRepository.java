package com.rococo.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.rococo.springboot.model.RecordMedicineAssoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordMedicineAssocRepository extends JpaRepository<RecordMedicineAssoc, Integer>{

}
