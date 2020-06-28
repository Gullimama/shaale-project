package com.realengagement.homeschool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realengagement.homeschool.jpa.entities.Role;
import com.realengagement.homeschool.jpa.entities.Users;
import com.realengagement.homeschool.jpa.repositories.RoleRepository;
import com.realengagement.homeschool.jpa.repositories.UsersRepository;

@Service
public class ClassService {

	@Autowired
	RoleRepository roleRepository; 
	
	@Autowired
	UsersRepository userRepository; 
	
	public List<Users> getClassStudents(Long classesId) {
		
		Role studentRole = roleRepository.findByname("STUDENT").get(0); 
		
		return userRepository.findByClassesIdAndRoleId(classesId, studentRole.getId()); 
	}
	
	

}
