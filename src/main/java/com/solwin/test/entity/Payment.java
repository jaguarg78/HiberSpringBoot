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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="GYM_PAYMENTS")
@DynamicInsert
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GPAY_ID", columnDefinition="serial")
	private BigInteger id;
	@JoinColumn(name="GPAY_GUSR_ID")
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private User user;
	@JoinColumn(name="GPAY_GSUB_ID")
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private Subscription subscription;
	@Column(name="GPAY_DISCOUNT")
	@NotNull
	private float discount;
	@Column(name="GPAY_AMOUNT")
	@NotNull
	private float amount;
	@Column(name="GPAY_DATE_STATEMENT")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date statementDate;
	@Column(name="GPAY_DATE_EXPIRATION")
	@Temporal(TemporalType.DATE)
	@Null
	private Date expirationDate;
	@Column(name="GPAY_DATE_PAYMENT")
	@Temporal(TemporalType.DATE)
	@Null
	private Date paymentDate;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getStatementDate() {
		return statementDate;
	}
	public void setStatementDate(Date statementDate) {
		this.statementDate = statementDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
}
