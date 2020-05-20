package com.realengagement.homeschool.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Daysofweek {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String day;

	public Long getId() {
		return id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	} 

}
