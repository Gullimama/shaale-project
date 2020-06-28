package com.realengagement.homeschool.models.aggregates;

import java.util.List;

import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Attendance;
import com.realengagement.homeschool.jpa.entities.Period;
import com.realengagement.homeschool.jpa.entities.Users;

@Component
public class ClassAttendanceAggregate {
	
	List<Attendance> attendanceList; 
	List<Users> classUsersList; 
	List<Period> classPeriodList;
	
	public List<Attendance> getAttendanceList() {
		return attendanceList;
	}
	public void setAttendanceList(List<Attendance> attendanceList) {
		this.attendanceList = attendanceList;
	}
	public List<Users> getClassUsersList() {
		return classUsersList;
	}
	public void setClassUsersList(List<Users> classUsersList) {
		this.classUsersList = classUsersList;
	}
	public List<Period> getClassPeriodList() {
		return classPeriodList;
	}
	public void setClassPeriodList(List<Period> classPeriodList) {
		this.classPeriodList = classPeriodList;
	} 
	
	
}
