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
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="GYM_USER")
@DynamicInsert
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GUSR_ID", columnDefinition="serial")
	private BigInteger id;
	@Column(name="GUSR_NAMES")
	@NotNull
	private String names;
	@Column(name="GUSR_LAST_NAMES")
	@NotNull
	private String lastNames;
	@Column(name="GUSR_USR")
	@NotNull
	private String usr;
	@Column(name="GUSR_PSWD")
	@NotNull
	private String pswd;
	@Column(name="GUSR_DOCUMENT")
	@NotNull
	private String document;
	@Column(name="GUSR_EMAIL")
	@NotNull
	private String email;
	@Column(name="GUSR_PHONE")
	@Null
	private String phone;
	@Column(name="GUSR_ADDRESS")
	@Null
	private String address;
	@JoinColumn(name="GUSR_GSUB_ID")
	@OneToOne(cascade = CascadeType.ALL)
	@Null
	private Subscription subscription;
	@Column(name="GUSR_MEDICAL_AUTH")
	@Lob
	@Null
	private byte[] medicalAuth;
	@Column(name="GUSR_AVATAR")
	@Lob
	@Null
	private byte[] avatar;
	@JoinColumn(name="GUSR_GUST_ID")
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private UserStatus userStatus;
	@Column(name="GUSR_STATUS_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date statusTimestamp;
	@Column(name="GUSR_CREATE_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@Null
	private Date createTimestamp;
	@Column(name="GUSR_UPDATE_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@Null
	private Date updateTimestamp;
	@Column(name="GUSR_DELETE_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@Null
	private Date deleteTimestamp;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getLastNames() {
		return lastNames;
	}
	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
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
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	public UserStatus getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
	public byte[] getMedicalAuth() {
		return medicalAuth;
	}
	public void setMedicalAuth(byte[] medicalAuth) {
		this.medicalAuth = medicalAuth;
	}
	public byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	public Date getStatusTimestamp() {
		return statusTimestamp;
	}
	public void setStatusTimestamp(Date statusTimestamp) {
		this.statusTimestamp = statusTimestamp;
	}
	public Date getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	public Date getDeleteTimestamp() {
		return deleteTimestamp;
	}
	public void setDeleteTimestamp(Date deleteTimestamp) {
		this.deleteTimestamp = deleteTimestamp;
	}
}
