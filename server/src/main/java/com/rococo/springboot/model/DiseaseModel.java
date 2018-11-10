package com.rococo.springboot.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="disease") // This tells Hibernate to name the table as Person and not PersonModel
public class DiseaseModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@NotEmpty
        @Size(min=1, message="Name should at least have 1 character")
        @Size(max=30, message="Name should at least have 30 characters")
        @Column(unique=true)
	private String name;

        @NotNull
	@NotEmpty
        @Size(min=1, message="List should at least have 1 medicine")
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="disease")
	private List<MedicineModel> meds;

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

        public List<MedicineModel> getMeds() {
            return meds;
        }

        public void setMeds(List<MedicineModel> meds) {
            this.meds = meds;
        }

        @Override
        public boolean equals (Object object) {
            boolean result = false;
            if (object == null || object.getClass() != getClass()) {
                result = false;
            } else {
                DiseaseModel med = (DiseaseModel) object;
                if (this.name.equals(med.getName())) {
                    result = true;
                }
            }
            return result;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 83 * hash + Objects.hashCode(this.name);
            return hash;
        }
}
