package com.rococo.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.rococo.springboot.model.MedicineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicineRepository extends JpaRepository<MedicineModel, Integer>{
    @Query("SELECT u FROM MedicineModel u WHERE u.name = :name")
    MedicineModel findByName(@Param("name") String given);
}
