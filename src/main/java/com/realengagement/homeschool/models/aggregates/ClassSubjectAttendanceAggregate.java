package com.realengagement.homeschool.models.aggregates;

import java.util.List;

import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Attendance;
import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Period;
import com.realengagement.homeschool.jpa.entities.Subject;
import com.realengagement.homeschool.jpa.entities.Users;

@Component
public class ClassSubjectAttendanceAggregate {
	
	List<Users> classStudentList; 
	Classes classes; 
	List<Period> subjectTeacherPeriodsForClassAndDay; 
	List<Attendance> studentAttendanceForSubject;
	List<Subject> subjects; 
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public List<Users> getClassStudentList() {
		return classStudentList;
	}
	public void setClassStudentList(List<Users> classStudentList) {
		this.classStudentList = classStudentList;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public List<Period> getSubjectTeacherPeriodsForClassAndDay() {
		return subjectTeacherPeriodsForClassAndDay;
	}
	public void setSubjectTeacherPeriodsForClassAndDay(List<Period> subjectTeacherPeriodsForClassAndDay) {
		this.subjectTeacherPeriodsForClassAndDay = subjectTeacherPeriodsForClassAndDay;
	}
	public List<Attendance> getStudentAttendanceForSubject() {
		return studentAttendanceForSubject;
	}
	public void setStudentAttendanceForSubject(List<Attendance> studentAttendanceForSubject) {
		this.studentAttendanceForSubject = studentAttendanceForSubject;
	} 
	
	
	

}
