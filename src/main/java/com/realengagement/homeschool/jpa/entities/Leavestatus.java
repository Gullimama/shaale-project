package com.realengagement.homeschool.jpa.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Leavestatus {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String status;

	public Long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
	
	
	
}
