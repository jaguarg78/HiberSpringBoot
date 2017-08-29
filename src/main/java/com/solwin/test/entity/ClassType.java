package com.solwin.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name="GYM_CLASS_TYPE")
public class ClassType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GCTY_ID", columnDefinition="serial")
	private Integer id;
	@Column(name="GCTY_NAME")
	@NotNull
	private String name;
	@Column(name="GCTY_DESCRIPTION")
	@NotNull
	private String description;
	@JoinColumn(name="GCTY_GSIT_ID")
	@OneToOne(cascade = CascadeType.ALL)
	@Null
	private Site site;
	
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
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
}
