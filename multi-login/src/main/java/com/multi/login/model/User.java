package com.multi.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;

	@NotBlank(message = "Name is mandatory!")
	private String name;

	private String email;
	
	@NotBlank(message = "password cannot be blank!")
	private String password;

	@Column(name = "not_social", columnDefinition = "boolean default true", nullable = false)
	private boolean notSocial;	
}
