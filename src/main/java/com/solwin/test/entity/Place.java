package com.solwin.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="GYM_PLACES")
@DynamicInsert
public class Place {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GPLA_ID", columnDefinition = "serial")
    private int id;  
	@Column(name="GPLA_NAME")
	@NotNull
    private String name;
	@Column(name="GPLA_OCUPATION")
	@NotNull
	private float ocupation;
	
	public int getId() {
		return id;
	}
	public void setId(int Id) {
		this.id = Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getOcupation() {
		return ocupation;
	}
	public void setOcupation(float ocupation) {
		this.ocupation = ocupation;
	}
}
