package com.realengagement.homeschool.models.aggregates;

import java.util.List;

import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Leave;
import com.realengagement.homeschool.jpa.entities.Leavestatus;
import com.realengagement.homeschool.jpa.entities.Users;

@Component
public class LeaveAggregate {
	List<Users> users; 
	List<Leave> leaves;
	List<Leavestatus> leaveStatus; 
	
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	public List<Leave> getLeaves() {
		return leaves;
	}
	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}
	public List<Leavestatus> getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(List<Leavestatus> leaveStatus) {
		this.leaveStatus = leaveStatus;
	} 
	
	
	
}
