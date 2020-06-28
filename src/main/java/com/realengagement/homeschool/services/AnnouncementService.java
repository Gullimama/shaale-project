package com.realengagement.homeschool.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realengagement.homeschool.jpa.entities.Announcement;
import com.realengagement.homeschool.jpa.entities.School;
import com.realengagement.homeschool.jpa.entities.Users;
import com.realengagement.homeschool.jpa.repositories.AnnouncementRepository;
import com.realengagement.homeschool.jpa.repositories.ClassesRepository;
import com.realengagement.homeschool.jpa.repositories.SchoolRepository;
import com.realengagement.homeschool.jpa.repositories.SubjectRepository;
import com.realengagement.homeschool.jpa.repositories.UsersRepository;
import com.realengagement.homeschool.models.ClassesAnnouncementRequest;
import com.realengagement.homeschool.models.SubjectTeacherAnnouncementsRequest;
import com.realengagement.homeschool.models.TeacherAnnouncementRequest;
import com.realengagement.homeschool.models.aggregates.ClassesAnnouncementAggregate;
import com.realengagement.homeschool.models.aggregates.SchoolAnnouncementAggregate;
import com.realengagement.homeschool.models.aggregates.SubjectTeacherAnnouncementAggregate;
import com.realengagement.homeschool.models.aggregates.TeacherAnnouncementAggregate;

@Service
public class AnnouncementService {
	
	@Autowired
	AnnouncementRepository announcementRepository;
	
	@Autowired
	ClassesAnnouncementAggregate classesAnnouncementAggregate; 
	
	@Autowired
	TeacherAnnouncementAggregate teacherAnnouncementAggregate; 
	
	@Autowired
	SchoolAnnouncementAggregate schoolAnnouncementAggregate; 
	
	@Autowired
	UsersRepository userRepository; 
	
	@Autowired
	SubjectRepository subjectRepository; 
	
	@Autowired
	SchoolRepository schoolRepository; 
	
	@Autowired
	ClassesRepository classesRepository; 

	public ClassesAnnouncementAggregate getClassesAnnouncements(ClassesAnnouncementRequest classesAnnouncementRequest) {
		classesAnnouncementAggregate = new ClassesAnnouncementAggregate(); 
		
		List<Announcement> announcementList = announcementRepository
				.findByClassesId(classesAnnouncementRequest.getClassesId()); 
		
		classesAnnouncementAggregate
			.setAnnouncementList(announcementList); 
		
		List<Long> authorIdList = announcementList.stream()
			.map(announcement -> announcement.getAuthorId())
			.collect(Collectors.toList()); 
		classesAnnouncementAggregate
			.setAuthorList(userRepository.findByIdIn(authorIdList));
		
		List<Long> subjectIdList = announcementList.stream()
				.map(announcement -> announcement.getSubjectId())
				.collect(Collectors.toList()); 
		classesAnnouncementAggregate
			.setClassSubjectList(subjectRepository.findByIdIn(subjectIdList));
		
		return classesAnnouncementAggregate; 
	}

	public TeacherAnnouncementAggregate getTeacherAnnouncements() {
		teacherAnnouncementAggregate = new TeacherAnnouncementAggregate(); 
		
		Users principal = getPrincipal(); 
		
		// get only where classesId==0 for teacher's only. 
		List<Announcement> announcementList = announcementRepository
				.findByAuthorId(principal.getId())
				.stream()
				.filter(announcement -> announcement.getClassesId().equals(classesRepository.findByClassesNo(0L).get(0).getId()))
				.collect(Collectors.toList())
				; 
		
		List<Long> authorIdList = announcementList.stream()
				.map(announcement -> announcement.getAuthorId())
				.collect(Collectors.toList()); 
		teacherAnnouncementAggregate
				.setAuthorList(userRepository.findByIdIn(authorIdList));
			
		List<Long> subjectIdList = announcementList.stream()
				.map(announcement -> announcement.getSubjectId())
				.collect(Collectors.toList()); 
		teacherAnnouncementAggregate
				.setClassSubjectList(subjectRepository.findByIdIn(subjectIdList));
		
		teacherAnnouncementAggregate.setAnnouncementList(announcementList);
		teacherAnnouncementAggregate.setPrincipal(principal);
		
		return teacherAnnouncementAggregate;
	}

	private Users getPrincipal() {
		Users principal = userRepository
				.findById((long) (((List<School>) schoolRepository
						.findAll())
						.get(0))
						.getPrincipalId()
						);
		
		return principal;
	}

	public SchoolAnnouncementAggregate getSchoolAnnouncements() {
		schoolAnnouncementAggregate = new SchoolAnnouncementAggregate(); 
		
		//System.out.println("School's class no: " + classesRepository.findByClassesNo(-1L).get(0).getId());
		List<Announcement> announcementList = announcementRepository
				.findByAuthorId(getPrincipal().getId())
				.stream()
				.filter(announcement -> announcement.getClassesId().equals(classesRepository.findByClassesNo(-1L).get(0).getId()))
				.collect(Collectors.toList()); 
		schoolAnnouncementAggregate
			.setAnnouncementList(announcementList);
		
		List<Long> authorIdList = announcementList.stream()
				.map(announcement -> announcement.getAuthorId())
				.collect(Collectors.toList()); 
		schoolAnnouncementAggregate
				.setAuthorList(userRepository.findByIdIn(authorIdList));
			
		List<Long> subjectIdList = announcementList.stream()
				.map(announcement -> announcement.getSubjectId())
				.collect(Collectors.toList()); 
		schoolAnnouncementAggregate
				.setClassSubjectList(subjectRepository.findByIdIn(subjectIdList));
		
		
		return schoolAnnouncementAggregate; 
	}

	public SubjectTeacherAnnouncementAggregate getSubjectTeacherAnnouncements(
			SubjectTeacherAnnouncementsRequest subjectTeacherAnnouncementsRequest) {
		SubjectTeacherAnnouncementAggregate sTAAggregate = new SubjectTeacherAnnouncementAggregate(); 
		
		
		List<Announcement> subjectTeacherMadeAnnouncements = announcementRepository
				.findByAuthorId(subjectTeacherAnnouncementsRequest.getUserId()); 
		sTAAggregate.setSubjectTeacherAnnouncements(subjectTeacherMadeAnnouncements);
		
		sTAAggregate.setClassesList(
				classesRepository.findByIdIn(subjectTeacherMadeAnnouncements
						.stream().map(a -> a.getClassesId()).collect(Collectors.toList())
								));
		
		return sTAAggregate;
	} 

}
