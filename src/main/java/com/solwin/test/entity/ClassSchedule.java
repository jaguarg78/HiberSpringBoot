package com.solwin.test.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="GYM_CLASS_SCHEDULE")
@DynamicInsert
public class ClassSchedule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GCLS_ID", columnDefinition="serial")
	private BigInteger id;
	@JoinColumn(name="GCLS_GCTY_ID")
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private ClassType classType;
	@JoinColumn(name="GCLS_GPLA_ID")
	@OneToOne(cascade = CascadeType.ALL)
	@Null
	private Place place;
	@Column(name="GCLS_MAX_CAPACITY")
	@NotNull
	private Integer maxCapacity;
	@Column(name="GCLS_ENROLLS")
	@NotNull
	private Integer enrolls;
	@Column(name="GCLS_WEEK_DAY")
	@NotNull
	private Integer weekDay;
	@Column(name="GCLS_TIME_START")
	@Temporal(TemporalType.TIME)
	@NotNull
	private Date timeStart;
	@Column(name="GCLS_TIME_END")
	@Temporal(TemporalType.TIME)
	@NotNull
	private Date timeEnd;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "GYM_USER_SCHEDULE",
	           joinColumns = {
	               @JoinColumn(name = "GUSS_GCLS_ID",
	            		       nullable = false,
	            		       updatable = false)
	           },
	           inverseJoinColumns = {
	        	   @JoinColumn(name = "GUSS_GUSR_ID",
		        			   nullable = false,
	            		       updatable = false)
	           })
	private Set<User> users = new HashSet<User>(0);
	@OneToMany(mappedBy = "classSchedule")
	private Set<TeacherClass> teacherClass = new HashSet<TeacherClass>(0);
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public Integer getEnrolls() {
		return enrolls;
	}
	public void setEnrolls(Integer enrolls) {
		this.enrolls = enrolls;
	}
	public Integer getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(Integer weekDay) {
		this.weekDay = weekDay;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<TeacherClass> getTeacherClass() {
		return teacherClass;
	}
	public void setTeacherClass(Set<TeacherClass> teacherClass) {
		this.teacherClass = teacherClass;
	}
}
