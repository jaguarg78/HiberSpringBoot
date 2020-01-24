package com.solwin.test.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name="GYM_TEACHER_CLASS")
public class TeacherClass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GTCP_ID", columnDefinition="serial")
	private BigInteger id;
	@JoinColumn(name="GTCP_GTCH_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	@NotNull	
	private Teacher teacher;
	@JoinColumn(name="GTCP_GCLS_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	@NotNull
	private ClassSchedule classSchedule;
	@Column(name="GTCP_PAY")
	@Null
	private float pay;

	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public ClassSchedule getClassSchedule() {
		return classSchedule;
	}
	public void setClassSchedule(ClassSchedule classSchedule) {
		this.classSchedule = classSchedule;
	}
	public float getPay() {
		return pay;
	}
	public void setPay(float pay) {
		this.pay = pay;
	}
}
