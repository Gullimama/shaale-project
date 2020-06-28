package com.realengagement.homeschool.models.aggregates;

import java.util.List;

import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Announcement;
import com.realengagement.homeschool.jpa.entities.Subject;
import com.realengagement.homeschool.jpa.entities.Users;

@Component
public class TeacherAnnouncementAggregate {
	
	List<Announcement> announcementList; 
	Users principal;
	List<Users> authorList;
	List<Subject> classSubjectList; 
	
	public List<Users> getAuthorList() {
		return authorList;
	}
	public void setAuthorList(List<Users> authorList) {
		this.authorList = authorList;
	}
	public List<Subject> getClassSubjectList() {
		return classSubjectList;
	}
	public void setClassSubjectList(List<Subject> classSubjectList) {
		this.classSubjectList = classSubjectList;
	}
	public List<Announcement> getAnnouncementList() {
		return announcementList;
	}
	public void setAnnouncementList(List<Announcement> announcementList) {
		this.announcementList = announcementList;
	}
	public Users getPrincipal() {
		return principal;
	}
	public void setPrincipal(Users principal) {
		this.principal = principal;
	} 
	
	
}
