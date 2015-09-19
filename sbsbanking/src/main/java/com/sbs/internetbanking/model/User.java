package com.sbs.internetbanking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER" , schema = "sbs_bank")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String username;
	private String password;
	private String email;

	@Id
	@Column(name = "USER_ID")
	public String getId() {
		return id;
	}

	@Column(name = "USER_NAME")
	public String getUsername() {
		return username;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		this.id = id;
	}
}
