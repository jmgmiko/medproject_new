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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
        @JoinColumn(name = "patient_id")
	private PatientModel patient;

        public PatientModel getPatient() {
            return patient;
        }

        public void setPatient(PatientModel patient) {
            this.patient = patient;
        }

	@NotNull
	private Double total;

        public Double getTotal() {
            return total;
        }

        public void setTotal(Double total) {
            this.total = total;
        }
        
        @Column(name = "admission", updatable=false)
        @Temporal(TemporalType.DATE)
        private Date admissionDate;
        
        @Column(name = "discharge")
        @Temporal(TemporalType.DATE)
        private Date dischargeDate = null;
        
        public void setDischarge() {  this.dischargeDate = new Date(); }

        public Date getAdmissionDate() {
            return admissionDate;
        }

        public Date getDischargeDate() {
            return dischargeDate;
        }     
        
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
        
        @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "disease_id", nullable = false)
        private DiseaseModel disease;

        public DiseaseModel getDisease() {
            return disease;
        }

        public void setDisease(DiseaseModel disease) {
            this.disease = disease;
        }      
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MedicalRecordModel record = (MedicalRecordModel) o;
            return Objects.equals(id, record.id) && Objects.equals(symptoms, record.getSymptoms()) && Objects.equals(total, record.total) && Objects.equals(patient, record.patient) && Objects.equals(dischargeDate, record.dischargeDate) && Objects.equals(admissionDate, record.admissionDate);
        }
        
        @NotNull
        @Column(name = "model_lkey")
        private Integer key;

        @Override
        public int hashCode() {
            return Objects.hash(id, total, patient, admissionDate, dischargeDate, symptoms);
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
        
        @PrePersist
	protected void onCreate() {
		this.setCreationDate(new Date());
                this.setKey();
                this.setTotal(0.0);
	}

	@PreUpdate
	protected void onPersist() {
		this.setModificationDate(new Date());
	}
}

