package com.realengagement.homeschool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.repositories.ClassesRepository;

@Controller
public class ClassesController {
	
	@Autowired
	ClassesRepository classesRepository; 
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value="/classes")
	public List<Classes> getAllClasses() {
		return (List<Classes>) classesRepository.findAll(); 
	}

}
