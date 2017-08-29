package com.solwin.test.structures;

import java.util.Date;

public class DateRange {
	private String type;
	private Date from;
	private Date to;
	
	public DateRange() { }
	public DateRange(String type, Date from, Date to) {
		this.type = type;
		this.from = from;
		this.to = to;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
}
