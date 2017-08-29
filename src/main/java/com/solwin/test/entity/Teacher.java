package com.solwin.test.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="GYM_TEACHER")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GTCH_ID", columnDefinition="serial")
	private Integer id;
	@JoinColumn(name="GTCH_GUSR_ID")
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private User user;
	@OneToMany(mappedBy = "teacher")
	private Set<TeacherClass> teacherClass = new HashSet<TeacherClass>(0);
	
	public Integer getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<TeacherClass> getTeacherClass() {
		return teacherClass;
	}
	public void setTeacherClass(Set<TeacherClass> teacherClass) {
		this.teacherClass = teacherClass;
	}
}
