package com.realengagement.homeschool.models;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Subject;

@Component
public class ArchivedClassRequest {
	
	Date startDate;
	Date endDate; 
	Long subjectId; 
	Long classesId;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public Long getClassesId() {
		return classesId;
	}
	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	} 
	
	

}
