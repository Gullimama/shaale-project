package com.realengagement.homeschool.models;

import org.springframework.stereotype.Component;

@Component
public class SubjectTeacherAnnouncementsRequest {
	Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	} 
	
	
}
