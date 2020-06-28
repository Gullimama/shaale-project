package com.realengagement.homeschool.models.aggregates;

import java.util.List;

import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Announcement;
import com.realengagement.homeschool.jpa.entities.Classes;

@Component
public class SubjectTeacherAnnouncementAggregate {
	
	List<Announcement> subjectTeacherAnnouncements; 
	List<Classes> classesList;
	public List<Announcement> getSubjectTeacherAnnouncements() {
		return subjectTeacherAnnouncements;
	}
	public void setSubjectTeacherAnnouncements(List<Announcement> subjectTeacherAnnouncements) {
		this.subjectTeacherAnnouncements = subjectTeacherAnnouncements;
	}
	public List<Classes> getClassesList() {
		return classesList;
	}
	public void setClassesList(List<Classes> classesList) {
		this.classesList = classesList;
	} 
	
	

}
