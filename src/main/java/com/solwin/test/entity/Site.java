package com.solwin.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="GYM_SITE")
public class Site {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GSIT_ID", columnDefinition="serial")
	private Integer id;
	@Column(name="GSIT_NAME")
	@NotNull
	private String name;
	@Column(name="GSIT_DESCRIPTION")
	@NotNull
	private String description;
	@Column(name="GSIT_EMAIL")
	@NotNull
	private String email;
	@Column(name="GSIT_PHONE")
	@NotNull
	private String phone;
	@Column(name="GSIT_ADDRESS")
	@NotNull
	private String address;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
