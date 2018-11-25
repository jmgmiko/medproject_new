package com.rococo.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user") // This tells Hibernate to name the table as user and not User
@DynamicInsert(true)
@DynamicUpdate(true)
public class User implements Serializable {

	public User() {
        this.modificationDate = new Date();
	};

	public User(Integer id, @NotEmpty String email,
			@NotEmpty @Size(min = 2, message = "Username should at least have 2 characters") @Size(max = 15, message = "Username should not exceed 15 characters") String username,
			@NotEmpty @Size(min = 2, message = "Password should at least have 2 characters") @Size(max = 15, message = "Password should not exceed 15 characters") String password,
			@NotNull @NotEmpty @Size(min = 2, message = "First Name should at least have 2 characters") @Size(max = 15, message = "FirstName should not exceed 15 characters") String firstName,
			@NotNull @NotEmpty @Size(min = 2, message = "Last Name should at least have 2 characters") @Size(max = 15, message = "Last Name should not exceed 15 characters") String lastName) {
		super();
        this.modificationDate = new Date();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(
			@NotEmpty @Size(min = 2, message = "Username should at least have 2 characters") @Size(max = 15, message = "Username should not exceed 15 characters") String username,
			@NotEmpty @Size(min = 2, message = "Password should at least have 2 characters") @Size(max = 15, message = "Password should not exceed 15 characters") String password) {
		super();
        this.modificationDate = new Date();
		this.username = username;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty
	@Column(name = "email")
	private String email;

	@NotEmpty
	@Length(min = 2, message = "Username should at least have 2 characters")
	@Length(max = 15, message = "Username should not exceed 15 characters")
	@Column(name = "username", nullable = false, updatable = false)
	private String username;

	@NotEmpty
	@Length(min = 2, message = "Password should at least have 2 characters")
	@Length(max = 15, message = "Password should not exceed 15 characters")
	@Column(name = "password", nullable = false, updatable = false)
	private String password;

	@NotNull
	@NotEmpty
	@Length(min = 2, message = "First Name should at least have 2 characters")
	@Length(max = 15, message = "FirstName should not exceed 15 characters")
	private String firstName;

	@NotNull
	@NotEmpty
	@Length(min = 2, message = "Last Name should at least have 2 characters")
	@Length(max = 15, message = "Last Name should not exceed 15 characters")
	private String lastName;
        
        @Column(name = "creation", updatable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date creationDate = new Date();
        
        @Column(name = "modification")
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date modificationDate;
        
        @NotNull
	@NotEmpty
        private Integer key;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
        
        @Override
        public int hashCode() {
            return Objects.hash(id, email, username, password, firstName, lastName);
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
        

	@PreUpdate
	protected void onPersist() {
		this.setModificationDate(new Date());
	}

        public Integer getKey() {
            return key;
        }

        public void setKey() {
            this.key = this.hashCode();
        }
        
        
}
