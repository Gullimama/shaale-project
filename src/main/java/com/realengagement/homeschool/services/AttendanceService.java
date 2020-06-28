package com.realengagement.homeschool.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realengagement.homeschool.jpa.entities.Attendance;
import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Period;
import com.realengagement.homeschool.jpa.entities.Subject;
import com.realengagement.homeschool.jpa.entities.Teaching;
import com.realengagement.homeschool.jpa.entities.Users;
import com.realengagement.homeschool.jpa.repositories.AttendanceRepository;
import com.realengagement.homeschool.jpa.repositories.ClassesRepository;
import com.realengagement.homeschool.jpa.repositories.PeriodRepository;
import com.realengagement.homeschool.jpa.repositories.SubjectRepository;
import com.realengagement.homeschool.jpa.repositories.TeachingRepository;
import com.realengagement.homeschool.jpa.repositories.UsersRepository;
import com.realengagement.homeschool.models.ClassAttendanceRequest;
import com.realengagement.homeschool.models.ClassSubjectAttendanceRequest;
import com.realengagement.homeschool.models.UserAttendanceRequest;
import com.realengagement.homeschool.models.aggregates.ClassSubjectAttendanceAggregate;
import com.realengagement.homeschool.models.aggregates.UserAttendanceAggregate;

@Service
public class AttendanceService {

	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	ClassService classService; 

	@Autowired
	UserAttendanceAggregate userAttendanceAggregate;
	
	@Autowired
	ClassSubjectAttendanceAggregate classSubjectAttendanceAggregate; 
	
	@Autowired
	ClassesRepository classesRepository; 
	
	@Autowired
	TeachingRepository teachingRepository; 
	
	@Autowired
	SubjectRepository subjectRepository; 
	
	@Autowired
	PeriodRepository periodRepository; 
	
	@Autowired
	TimetableService timetableService; 
	
	@Autowired
	UsersRepository userRepository; 

	public synchronized UserAttendanceAggregate getUserAttendace(UserAttendanceRequest userAttendanceRequest) {
		// View only preferred for Teacher
		// For Teacher or For a particular user
		// default to 7 days

		userAttendanceAggregate = new UserAttendanceAggregate();

		// verify if the user is a teacher.
		if (!verifyTeacher(userAttendanceRequest.getUserId()))
			return userAttendanceAggregate;

		List<Attendance> attendances = attendanceRepository.findByUserIdAndDatedBetween(
				userAttendanceRequest.getUserId(), userAttendanceRequest.getStartDate(),
				userAttendanceRequest.getEndDate());

		userAttendanceAggregate.setAttendance(attendances);

		return userAttendanceAggregate;
	}

	private boolean verifyTeacher(Long userId) {
		return true;
	}

	public UserAttendanceAggregate getClassAttendance(ClassAttendanceRequest classAttendanceRequest) {
		userAttendanceAggregate = new UserAttendanceAggregate();

		// verify if the user is a teacher.
		if (!verifyTeacher(classAttendanceRequest.getUserId()))
			return userAttendanceAggregate;
		
		List<Long> classStudentIds = classService
				.getClassStudents(classAttendanceRequest.getClassesId())
				.stream()
				.map(student -> student.getId())
				.collect(Collectors.toList()); 
		
		List<Attendance> attendances = attendanceRepository.findByUserIdInAndDatedBetween(
				classStudentIds, classAttendanceRequest.getStartDate(),
				classAttendanceRequest.getEndDate());
		
		userAttendanceAggregate.setAttendance(attendances);
		userAttendanceAggregate.setUsersList(userRepository.findByClassesId(classAttendanceRequest.getClassesId()));
		userAttendanceAggregate.setSubjectList(subjectRepository.findByClassesId(classAttendanceRequest.getClassesId())); 
		userAttendanceAggregate.setPeriodsList(periodRepository.findByClassesId(classAttendanceRequest.getClassesId()));
		
		return userAttendanceAggregate;
	}

	public ClassSubjectAttendanceAggregate getClassSubjectAttendance(ClassSubjectAttendanceRequest classSubjectAttendanceRequest) {
		classSubjectAttendanceAggregate = new ClassSubjectAttendanceAggregate(); 

		// verify if the user is a teacher.
		if (!verifyTeacher(classSubjectAttendanceRequest.getSubjectTeacherId()))
			return classSubjectAttendanceAggregate;
		
		List<Teaching> subjectTeacherTeaching = teachingRepository
			.findByTeacherIdAndClassesId(classSubjectAttendanceRequest.getSubjectTeacherId(), 
					classSubjectAttendanceRequest.getClassesId()); 
		
		Classes subjectTeacherAssociatedClass = classesRepository
				.findById((long) classSubjectAttendanceRequest.getClassesId()); 
		
		List<Long> subjectTeacherAssociatedSubjectIds = subjectTeacherTeaching
				.stream()
				.map(teaching -> teaching.getSubjectId())
				.collect(Collectors.toList()); 
		List<Subject> subjectTeacherAssociatedSubjects = subjectRepository
				.findByIdIn(subjectTeacherAssociatedSubjectIds); 
		
		List<Period> periodList = periodRepository
				.findByClassesId(classSubjectAttendanceRequest.getClassesId()); 
		List<Long> periodIdList = periodList.stream().map(period -> period.getId()).collect(Collectors.toList()); 
		
		
		List<Users> classStudentList = classService.getClassStudents(classSubjectAttendanceRequest.getClassesId()); 
		List<Long> classStudentIdList = classStudentList.stream().map(student -> student.getId()).collect(Collectors.toList()); 
		List<Attendance> classSubjectAttendanceList = attendanceRepository
				.findByUserIdInAndPeriodIdInAndDatedBetween(classStudentIdList, periodIdList, 
						classSubjectAttendanceRequest.getStartDate(), classSubjectAttendanceRequest.getEndDate()); 
		
		classSubjectAttendanceAggregate.setClasses(subjectTeacherAssociatedClass);
		classSubjectAttendanceAggregate.setClassStudentList(classStudentList);
		classSubjectAttendanceAggregate.setStudentAttendanceForSubject(classSubjectAttendanceList);
		classSubjectAttendanceAggregate.setSubjects(subjectTeacherAssociatedSubjects); 
		
		return classSubjectAttendanceAggregate;
	}

}
