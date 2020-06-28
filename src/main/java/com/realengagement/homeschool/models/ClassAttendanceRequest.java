package com.realengagement.homeschool.models;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClassAttendanceRequest {
	
	private Long userId; 
	private Long classesId; 
	private Date startDate; 
	private Date endDate;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getClassesId() {
		return classesId;
	}
	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		if (endDate == null)
			endDate = addDays(startDate, 0);
		return endDate; 
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	} 
	
	

}
