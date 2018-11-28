package com.rococo.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="medicine") // This tells Hibernate to name the table as Person and not PersonModel
public class MedicineModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
        
//        @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//        )
//        private List<RecordMedicineAssoc> records;

        public MedicineModel(
                Integer id, 
                @NotNull @NotEmpty @Length(min=1, message="Name should at least have 1 character") @Length(max=30, message="Name should at least have 30 characters") String name, 
                @NotNull double price, 
                String manuf) {
            super();
            this.id = id;
            this.name = name;
            this.price = price;
            this.manuf = manuf;
        }

        public MedicineModel() {
        }            

	@NotNull
	@NotEmpty
        @Length(min=1, message="Name should at least have 1 character")
        @Length(max=30, message="Name should at least have 30 characters")
        @Column(unique=true)
	private String name;
        
        @NotNull
        private double price;

	private String manuf;
       
        @Column(name = "model_lkey")
        private Integer key;
        
        @Column(name = "creation", updatable=false)
        private Date creationDate = new Date();
        
        @Column(name = "modification")
        private Date modificationDate;

        public Integer getId() {
            return id;
        }
        
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

        public String getManuf() {
            return manuf;
        }

        public void setManuf(String manuf) {
            this.manuf = manuf;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

//        public List<RecordMedicineAssoc> getRecords() {
//            return records;
//        }
//
//        public void setRecords(List<RecordMedicineAssoc> records) {
//            this.records = records;
//        } 
        
        @Override
        public boolean equals (Object object) {
            boolean result = false;
            if (object == null || object.getClass() != getClass()) {
                result = false;
            } else {
                MedicineModel med = (MedicineModel) object;
                return this.name.equals(med.getName())&&this.manuf.equals(med.getManuf())
                        &&this.price==med.getPrice();
            }
            return result;
        }        
        
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 83 * hash + Objects.hashCode(this.name);
            hash = 83 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
            hash = 83 * hash + Objects.hashCode(this.manuf);
            return hash;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey() {
            this.key = this.hashCode();
        }

        public Date getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Date creationDate) {
            this.creationDate = creationDate;
        }

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
	}

	@PreUpdate
	protected void onPersist() {
		this.setModificationDate(new Date());
	}
        
}
