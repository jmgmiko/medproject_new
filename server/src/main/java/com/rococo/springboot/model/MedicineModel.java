package com.rococo.springboot.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="medicine") // This tells Hibernate to name the table as Person and not PersonModel
public class MedicineModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
        
        @OneToMany(
            mappedBy = "medicine",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
        private List<RecordMedicine> records;

	@NotNull
	@NotEmpty
        @Size(min=1, message="Name should at least have 1 character")
        @Size(max=30, message="Name should at least have 30 characters")
        @Column(unique=true)
	private String name;
        
        @NotNull
        @NotEmpty
        private double price;

	private String manuf;

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

        public List<RecordMedicine> getRecords() {
            return records;
        }

        public void setRecords(List<RecordMedicine> records) {
            this.records = records;
        } 
        
        @Override
        public boolean equals (Object object) {
            boolean result = false;
            if (object == null || object.getClass() != getClass()) {
                result = false;
            } else {
                MedicineModel med = (MedicineModel) object;
                if (this.name.equals(med.getName())&&this.manuf.equals(med.getManuf())&&this.price==med.getPrice()) {
                    result = true;
                }
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
        
}
