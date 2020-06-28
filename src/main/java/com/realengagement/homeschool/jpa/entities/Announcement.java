package com.realengagement.homeschool.jpa.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    // 0=TeacherAnnouncment, -1=SchoolAnnouncement
	private Long classesId; 
	private Time timed; 
	private Date dated; 
	private Long subjectId; 
	private String topic; 
	private String datum;
	@Override
	public String toString() {
		return "Announcement [id=" + id + ", classesId=" + classesId + ", timed=" + timed + ", dated=" + dated
				+ ", subjectId=" + subjectId + ", topic=" + topic + ", datum=" + datum + ", authorId=" + authorId + "]";
	}
	private Long authorId;
	
	public Long getId() {
		return id;
	}
	public Long getClassesId() {
		return classesId;
	}
	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
	public Time getTimed() {
		return timed;
	}
	public void setTimed(Time timed) {
		this.timed = timed;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	} 
	
	
}
