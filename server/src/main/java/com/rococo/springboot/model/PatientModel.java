package com.rococo.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="patient") // This tells Hibernate to name the table as Person and not PersonModel
public class PatientModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@NotEmpty
        @Column(unique=true)
        @Size(min=1, message="Name should at least have 1 character")
        @Size(max=254, message="Name should at least have 254 characters")
	private String name;
        
        @NotNull
        @NotEmpty
        @Temporal(TemporalType.TIMESTAMP)
        @Column(unique=true)
        private Date birth;

        @NotNull
        @NotEmpty
	private String sex;

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

        public Date getBirth() {
            return birth;
        }

        public void setBirth(Date birth) {
            this.birth = birth;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
        
        
        
        
}
