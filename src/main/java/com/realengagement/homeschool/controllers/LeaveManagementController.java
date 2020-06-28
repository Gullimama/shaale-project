package com.realengagement.homeschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Users;
import com.realengagement.homeschool.models.LeaveApplyRequest;
import com.realengagement.homeschool.models.aggregates.LeaveAggregate;
import com.realengagement.homeschool.services.LeaveManagementService;

@Controller
@ResponseBody
public class LeaveManagementController {
	
	@Autowired
	LeaveManagementService leaveManagementService; 
	
	@RequestMapping("/leaves/class/{classesId}")
	public LeaveAggregate getClassLeaves(@PathVariable Long classesId) {
		return leaveManagementService.getClassLeaves(new Classes(classesId)); 
	}
	
	@RequestMapping("/leaves/user/{userId}")
	public LeaveAggregate getUserLeaves(@PathVariable Long userId) {
		return leaveManagementService.getUserLeaves(new Users(userId)); 
	}
	
	@RequestMapping("/leave-apply")
	public boolean applyNewLeave(@RequestParam String startDate, 
			@RequestParam String endDate, @RequestParam String reason, 
			@RequestParam String userId) {
		
		LeaveApplyRequest leaveApplyRequest = new LeaveApplyRequest(); 
		leaveApplyRequest.setEndDate(endDate);
		leaveApplyRequest.setStartDate(startDate);
		leaveApplyRequest.setReason(reason);
		leaveApplyRequest.setUserId(userId);
		
		return leaveManagementService.applyNewLeave(leaveApplyRequest); 
	}

}
