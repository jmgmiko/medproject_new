package com.rococo.springboot.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user") // This tells Hibernate to name the table as user and not User
@DynamicInsert(true)
@DynamicUpdate(true)
public class User implements Serializable {

	public User() {
	};

	public User(Integer id, @NotEmpty String email,
			@NotEmpty @Size(min = 2, message = "Username should at least have 2 characters") @Size(max = 15, message = "Username should not exceed 15 characters") String username,
			@NotEmpty @Size(min = 2, message = "Password should at least have 2 characters") @Size(max = 15, message = "Password should not exceed 15 characters") String password,
			@NotNull @NotEmpty @Size(min = 2, message = "First Name should at least have 2 characters") @Size(max = 15, message = "FirstName should not exceed 15 characters") String firstName,
			@NotNull @NotEmpty @Size(min = 2, message = "Last Name should at least have 2 characters") @Size(max = 15, message = "Last Name should not exceed 15 characters") String lastName) {
		super();
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
	@Size(min = 2, message = "Username should at least have 2 characters")
	@Size(max = 15, message = "Username should not exceed 15 characters")
	@Column(name = "username", nullable = false, updatable = false)
	private String username;

	@NotEmpty
	@Size(min = 2, message = "Password should at least have 2 characters")
	@Size(max = 15, message = "Password should not exceed 15 characters")
	@Column(name = "password", nullable = false, updatable = false)
	private String password;

	@NotNull
	@NotEmpty
	@Size(min = 2, message = "First Name should at least have 2 characters")
	@Size(max = 15, message = "FirstName should not exceed 15 characters")
	private String firstName;

	@NotNull
	@NotEmpty
	@Size(min = 2, message = "Last Name should at least have 2 characters")
	@Size(max = 15, message = "Last Name should not exceed 15 characters")
	private String lastName;

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

        
        
}
