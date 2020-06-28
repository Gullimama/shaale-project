package com.realengagement.homeschool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realengagement.homeschool.jpa.entities.Announcement;
import com.realengagement.homeschool.jpa.repositories.AnnouncementRepository;
import com.realengagement.homeschool.models.ClassesAnnouncementRequest;
import com.realengagement.homeschool.models.SubjectTeacherAnnouncementsRequest;
import com.realengagement.homeschool.models.aggregates.ClassesAnnouncementAggregate;
import com.realengagement.homeschool.models.aggregates.SchoolAnnouncementAggregate;
import com.realengagement.homeschool.models.aggregates.SubjectTeacherAnnouncementAggregate;
import com.realengagement.homeschool.models.aggregates.TeacherAnnouncementAggregate;
import com.realengagement.homeschool.services.AnnouncementService;

@Controller
@ResponseBody
public class AnnouncementController {
	
	@Autowired
	AnnouncementService announcementService;
	
	@Autowired
	AnnouncementRepository announcementRepository; 
	
	@RequestMapping("/announcements/classes")
	public ClassesAnnouncementAggregate getClassesAnnouncements(@RequestBody ClassesAnnouncementRequest classesAnnouncementRequest) {
		return announcementService.getClassesAnnouncements(classesAnnouncementRequest); 
	}
	
	@RequestMapping("/announcements/principal/teacher")
	public TeacherAnnouncementAggregate getTeacherAnnoucements() {
		return announcementService.getTeacherAnnouncements(); 
	}
	
	@RequestMapping("/announcements/principal/school")
	public SchoolAnnouncementAggregate getSchoolAnnouncements() {
		return announcementService.getSchoolAnnouncements(); 
	}
	
	@RequestMapping("/announcements/teacher")
	public SubjectTeacherAnnouncementAggregate getSubjectTeacherAnnouncements(SubjectTeacherAnnouncementsRequest subjectTeacherAnnouncementsRequest) {
		return announcementService.getSubjectTeacherAnnouncements(subjectTeacherAnnouncementsRequest); 
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value="/announcements")
	public Announcement insertNewAnnouncement(@RequestBody Announcement newAnnouncement) {
		return announcementRepository.save(newAnnouncement); 
	}
}
