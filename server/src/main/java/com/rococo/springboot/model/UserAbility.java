package com.rococo.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity // This tells Hibernate to make a table out of this class
@DynamicInsert(true)
@DynamicUpdate(true)
public class UserAbility implements Serializable {

	public UserAbility() {
	};

	public UserAbility(User user, String post) {
		super();
		this.user = user;
                this.position = post;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
        @Column(name = "updated_at", nullable = false)
        @LastModifiedDate
        private Date updatedAt;
        
        @NotNull
        @NotEmpty
        private String position;

}
