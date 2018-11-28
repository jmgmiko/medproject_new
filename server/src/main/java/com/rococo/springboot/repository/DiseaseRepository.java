package com.rococo.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.rococo.springboot.model.DiseaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiseaseRepository extends CrudRepository<DiseaseModel, Integer>{
    @Query("SELECT u FROM DiseaseModel u WHERE u.name = (:name)")
    DiseaseModel findDiseaseByName(@Param("name") String given);
}
