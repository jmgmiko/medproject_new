/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rococo.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author UESR
 */
@Entity // This tells Hibernate to make a table out of this class
@Table(name="record_association") // This tells Hibernate to name the table as Person and not PersonModel
public class RecordMedicineAssoc implements Serializable {
    @EmbeddedId
    private RecordMedicineId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_entity")
    private MedicalRecordModel record;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "med_entity")
    private MedicineModel med;
    
    @Column(name = "created_on")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdOn = null;
    
    @NotNull
    private Integer count;

    public RecordMedicineAssoc() {
    }    
    
    public RecordMedicineAssoc(MedicalRecordModel record, MedicineModel med) {
        this.record = record;
        this.med = med;
        this.count = 0;
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
 
        RecordMedicineAssoc that = (RecordMedicineAssoc) o;
        return Objects.equals(record, that.record) && 
               Objects.equals(med, that.med);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(record, med);
    }
    
    @PrePersist
	protected void onCreate() {
		this.createdOn=new Date();
	}
    
}
