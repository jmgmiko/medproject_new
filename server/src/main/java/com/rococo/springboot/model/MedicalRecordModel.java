package com.rococo.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "medical_record") // This tells Hibernate to name the table as User and not UserModel
public class MedicalRecordModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@NotEmpty
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "patient_id")
	private PatientModel patient;

        public PatientModel getPatient() {
            return patient;
        }

        public void setPatient(PatientModel patient) {
            this.patient = patient;
        }

	@NotNull
	@NotEmpty
	private Double total;

        public Double getTotal() {
            return total;
        }

        public void setTotal(Double total) {
            this.total = total;
        }
        
        @Column(name = "admission", updatable=false)
        private Date admissionDate = new Date();
        
        @Column(name = "discharge")
        private Date dischargeDate = new Date();
        
        @PreUpdate
        public void setDischarge() {  this.dischargeDate = new Date(); }

        public Date getAdmissionDate() {
            return admissionDate;
        }

        public Date getDischargeDate() {
            return dischargeDate;
        }     
        
        @NotNull
	@NotEmpty
        @Size(min=1, message="List should at least have 1 symptom")
        @ElementCollection
	private List<String> symptoms;
        
        public List<String> getSymptoms() {
            return symptoms;
        }

        public void setSymptoms(List<String> symptoms) {
            this.symptoms = symptoms;
        }
     
        @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
        private List<RecordMedicineAssoc> medicine;
        
        public void addMedicine(MedicineModel med) {
            RecordMedicineAssoc give = new RecordMedicineAssoc(this, med);
            medicine.add(give);
            med.getRecords().add(give);
        }

        public void removeTag(MedicineModel med) {
            for (Iterator<RecordMedicineAssoc> iterator = medicine.iterator(); 
                 iterator.hasNext(); ) {
                RecordMedicineAssoc some = iterator.next();

                if (some.getMed().equals(med) &&
                        some.getRecord().equals(this)) {
                    iterator.remove();
                    some.getMed().getRecords().remove(some);
                    some.setMed(null);
                    some.setRecord(null);
                }
            }
        }

        public List<RecordMedicineAssoc> getMedicine() {
            return medicine;
        }     
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MedicalRecordModel record = (MedicalRecordModel) o;
            return Objects.equals(id, record.id) && Objects.equals(symptoms, record.getSymptoms()) && Objects.equals(total, record.total) && Objects.equals(patient, record.patient) && Objects.equals(dischargeDate, record.dischargeDate) && Objects.equals(admissionDate, record.admissionDate);
        }
        
        @NotNull
	@NotEmpty
        private Integer key;

        @Override
        public int hashCode() {
            return Objects.hash(id, total, patient, admissionDate, dischargeDate, medicine, symptoms);
        }

        public Integer getKey() {
            return key;
        }

        public void setKey() {
            this.key = this.hashCode();
        }
        
        @Column(name = "creation", updatable=false)
        private Date creationDate = new Date();

        public Date getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Date creationDate) {
            this.creationDate = creationDate;
        }       
        
        @Column(name = "modification")
        private Date modificationDate = new Date();

        public Date getModificationDate() {
            return modificationDate;
        }

        public void setModificationDate(Date modificationDate) {
            this.modificationDate = modificationDate;
        }
        
        
}

