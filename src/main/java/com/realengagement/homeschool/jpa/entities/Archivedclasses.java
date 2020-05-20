package com.realengagement.homeschool.jpa.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Archivedclasses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private Long classesId; 
	private Date dated; 
	private Long periodId; 
	private Long subjectId; 
	private Long teacherId; 
	private String videourl; 
	private String type; 
	private Long chapterId;
	public Long getId() {
		return id;
	}
	public Long getClassesId() {
		return classesId;
	}
	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public Long getPeriodId() {
		return periodId;
	}
	public void setPeriodId(Long periodId) {
		this.periodId = periodId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getVideourl() {
		return videourl;
	}
	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getChapterId() {
		return chapterId;
	}
	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	} 
	
	

}
