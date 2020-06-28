package com.realengagement.homeschool.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Leave;
import com.realengagement.homeschool.jpa.entities.Leavestatus;
import com.realengagement.homeschool.jpa.entities.Users;
import com.realengagement.homeschool.jpa.repositories.LeaveRepository;
import com.realengagement.homeschool.jpa.repositories.LeavestatusRepository;
import com.realengagement.homeschool.jpa.repositories.UsersRepository;
import com.realengagement.homeschool.models.LeaveApplyRequest;
import com.realengagement.homeschool.models.aggregates.LeaveAggregate;

@Service
public class LeaveManagementService {
	
	@Autowired
	LeaveRepository leaveRepository; 
	
	@Autowired
	UsersRepository userRepository; 
	
	@Autowired
	LeavestatusRepository leavestatusRepository; 
	
	public LeaveAggregate getClassLeaves(Classes classes) {
		LeaveAggregate leaveAggregate = new LeaveAggregate(); 
		
		List<Users> users = userRepository.findByClassesId(classes.getId()); 
		leaveAggregate.setUsers(users);
		
		List<Long> userIds = users
							.stream()
							.map(user -> user.getId())
							.collect(Collectors.toList()); 
		leaveAggregate.setLeaves(leaveRepository.findByReferenceIdIn(userIds)); 
		
		leaveAggregate.setLeaveStatus((List<Leavestatus>) leavestatusRepository.findAll());
		
		return leaveAggregate; 
	}
	
	public LeaveAggregate getUserLeaves(Users users) {
		LeaveAggregate leaveAggregate = new LeaveAggregate(); 
		
		leaveAggregate.setUsers(Arrays.asList(userRepository.findById((long) users.getId())));
		
		leaveAggregate.setLeaves(leaveRepository.findByReferenceIdIn(Arrays.asList(users.getId()))); 
		
		leaveAggregate.setLeaveStatus((List<Leavestatus>) leavestatusRepository.findAll());
		
		return leaveAggregate; 
	}
	
	public boolean applyNewLeave(LeaveApplyRequest leaveApplyRequest) {
		Leave leave = new Leave(); 
		
		try {
			leave.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(leaveApplyRequest.getStartDate()));
			leave.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(leaveApplyRequest.getStartDate()));
			leave.setReason(leaveApplyRequest.getReason());
			leave.setStatusId(leavestatusRepository.findByStatus("PENDING").getId());
			leave.setReferenceId(Long.parseLong(leaveApplyRequest.getUserId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
		
		leaveRepository.save(leave); 
		
		return true; 
	}

}
