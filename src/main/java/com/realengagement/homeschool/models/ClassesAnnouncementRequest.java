package com.realengagement.homeschool.models;

import org.springframework.stereotype.Component;

@Component
public class ClassesAnnouncementRequest {
	
	private Long userId; 
	private Long classesId;
	
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
	
	
}
