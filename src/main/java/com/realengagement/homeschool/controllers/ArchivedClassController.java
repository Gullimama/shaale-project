package com.realengagement.homeschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realengagement.homeschool.models.ArchivedClassRequest;
import com.realengagement.homeschool.models.aggregates.RecordedClassAggregate;
import com.realengagement.homeschool.services.RecordedClassService;

@Controller
public class ArchivedClassController {
	
	@Autowired
	RecordedClassService recordedClassService; 
	
	
	@RequestMapping("/archived/class")
	public RecordedClassAggregate getArchivedClass(ArchivedClassRequest archivedClassRequest) {
		return recordedClassService.getArchivedClass(archivedClassRequest); 
	}

}
