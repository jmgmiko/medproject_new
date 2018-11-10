/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rococo.springboot.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author UESR
 */
@Embeddable
public class RecordMedicineId implements Serializable {

    @Column(name = "record_id")
    private Integer record;
    
    @Column(name = "medicine_id")
    private Integer medicine;
    
    public RecordMedicineId() {
    }
    
    public RecordMedicineId(Integer recordId, Integer medId) {
        this.record = recordId;
        this.medicine = medId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        RecordMedicineId that = (RecordMedicineId) o;
        return Objects.equals(record, that.record) && 
               Objects.equals(medicine, that.medicine);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(record, medicine);
    }
}
