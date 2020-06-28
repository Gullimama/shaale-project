package com.realengagement.homeschool.models;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

@Component
public class ClassSubjectAttendanceRequest {
	
	Date startDate;
	Date endDate; 
	Long classesId;
	Long subjectTeacherId; 
	
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getSubjectTeacherId() {
		return subjectTeacherId;
	}
	public void setSubjectTeacherId(Long subjectTeacherId) {
		this.subjectTeacherId = subjectTeacherId;
	}
	
	public Long getClassesId() {
		return classesId;
	}
	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	} 
	public Date getEndDate() {
		if (endDate == null)
			endDate = addDays(startDate, 1);
		return endDate; 
	}
	
	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	} 
	
	
	

}
