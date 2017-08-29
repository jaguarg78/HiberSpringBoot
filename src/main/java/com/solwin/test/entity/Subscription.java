package com.solwin.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="GYM_SUBSCRIPTION")
public class Subscription {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GSUB_ID", columnDefinition="serial")
	private Integer Id;
	@Column(name="GSUB_NAME")
	@NotNull
	private String name;
	@Column(name="GSUB_MONTHLY_FEE")
	@NotNull
	private Float monthlyFee;
	@Column(name="GSUB_DESCRIPTION")
	@NotNull
	private String description;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getMonthlyFee() {
		return monthlyFee;
	}
	public void setMonthlyFee(Float monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
