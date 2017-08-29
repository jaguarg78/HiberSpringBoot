package com.solwin.test.structures;

import java.math.BigInteger;
import java.util.Date;

public class Schedule {
	private BigInteger teacherId;
	private BigInteger userId;
	private Integer placeId;
	private Integer cTypeId;
	private Integer wok;
	private Date timeFrom;
	private Date timeTo;
	private Date dateFrom;
	private Date dateTo;
	private Float enroll;
	
	public Schedule() { }
	public Schedule(BigInteger teacherId, 
			        BigInteger userId, 
			        Integer placeId, 
			        Integer cTypeId, 
			        Integer wok, 
			        Date timeFrom,
			        Date timeTo, 
			        Date dateFrom, 
			        Date dateTo, 
			        Float enroll) {
		this.teacherId = teacherId;
		this.userId = userId;
		this.placeId = placeId;
		this.cTypeId = cTypeId;
		this.wok = wok;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.enroll = enroll;
	}
	
    public BigInteger getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(BigInteger teacherId) {
		this.teacherId = teacherId;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public Integer getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}
	public Integer getcTypeId() {
		return cTypeId;
	}
	public void setcTypeId(Integer cTypeId) {
		this.cTypeId = cTypeId;
	}
	public Integer getWok() {
		return wok;
	}
	public void setWok(Integer wok) {
		this.wok = wok;
	}
	public Float getEnroll() {
		return enroll;
	}
	public void setEnroll(Float enroll) {
		this.enroll = enroll;
	}
	public Date getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}
	public Date getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
}
