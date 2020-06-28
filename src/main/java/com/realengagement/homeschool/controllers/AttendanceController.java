package com.realengagement.homeschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realengagement.homeschool.models.ClassAttendanceRequest;
import com.realengagement.homeschool.models.ClassSubjectAttendanceRequest;
import com.realengagement.homeschool.models.UserAttendanceRequest;
import com.realengagement.homeschool.models.aggregates.ClassSubjectAttendanceAggregate;
import com.realengagement.homeschool.models.aggregates.UserAttendanceAggregate;
import com.realengagement.homeschool.services.AttendanceService;

@Controller
@ResponseBody
public class AttendanceController {
	
	@Autowired
	AttendanceService attendanceService; 
	
	// return a timetable of teacher's attendace that was attended. 
	@RequestMapping("/attendance/user")
	@ResponseBody
	public UserAttendanceAggregate getUserAttendance(@RequestBody UserAttendanceRequest userAttendanceRequest) {
		return attendanceService.getUserAttendace(userAttendanceRequest); 
	}
	
	@RequestMapping("/attendance/class")
	public UserAttendanceAggregate getClassAttendance(@RequestBody ClassAttendanceRequest classAttendanceRequest) {
		return attendanceService.getClassAttendance(classAttendanceRequest); 
	}
	
	@RequestMapping("/attendance/class/subject")
	public ClassSubjectAttendanceAggregate getClassesSubjectAttendance(@RequestBody ClassSubjectAttendanceRequest classSubjectAttendanceRequest) {
		return attendanceService.getClassSubjectAttendance(classSubjectAttendanceRequest); 
	}

}
