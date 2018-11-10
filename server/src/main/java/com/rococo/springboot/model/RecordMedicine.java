/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rococo.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author UESR
 */
@Entity // This tells Hibernate to make a table out of this class
@Table(name="disease_medicine") // This tells Hibernate to name the table as Person and not PersonModel
public class RecordMedicine implements Serializable {
    @EmbeddedId
    private RecordMedicineId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("medical_record")
    private MedicalRecordModel record;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("medicine")
    private MedicineModel med;
    
    @Column(name = "created_on")
    private Date createdOn = new Date();
    
    @NotEmpty
    @NotNull
    private Integer count;

    public RecordMedicine(MedicalRecordModel record, MedicineModel med) {
        this.record = record;
        this.med = med;
        this.id = new RecordMedicineId(record.getId(), med.getId());
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public RecordMedicineId getId() {
        return id;
    }

    public void setId(RecordMedicineId id) {
        this.id = id;
    }

    public MedicalRecordModel getRecord() {
        return record;
    }

    public void setRecord(MedicalRecordModel record) {
        this.record = record;
    }

    public MedicineModel getMed() {
        return med;
    }

    public void setMed(MedicineModel med) {
        this.med = med;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        RecordMedicine that = (RecordMedicine) o;
        return Objects.equals(record, that.record) && 
               Objects.equals(med, that.med);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(record, med);
    }
    
}
