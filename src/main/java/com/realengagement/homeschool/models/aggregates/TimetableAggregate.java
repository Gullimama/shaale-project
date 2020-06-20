package com.realengagement.homeschool.models.aggregates;

import java.util.List;

import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Daysofweek;
import com.realengagement.homeschool.jpa.entities.Period;
import com.realengagement.homeschool.jpa.entities.Subject;
import com.realengagement.homeschool.jpa.entities.Teaching;
import com.realengagement.homeschool.jpa.entities.Timetable;
import com.realengagement.homeschool.jpa.entities.Users;

public class TimetableAggregate {

    private List<Classes> classes;
    private List<Daysofweek> daysofweek;
    private List<Period> periods;
    private List<Subject> subjects;
    private List<Timetable> timetables;
    private List<Users> teachers; 
    private List<Teaching> teachings; 

    public List<Users> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Users> teachers) {
		this.teachers = teachers;
	}

	public List<Teaching> getTeachings() {
		return teachings;
	}

	public void setTeachings(List<Teaching> teachings) {
		this.teachings = teachings;
	}

    public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public List<Daysofweek> getDaysofweek() {
        return daysofweek;
    }

    public void setDaysofweek(List<Daysofweek> daysofweek) {
        this.daysofweek = daysofweek;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Timetable> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<Timetable> timetables) {
		this.timetables = timetables;
	}

	public void setDaysOfWeek(List<Daysofweek> daysOfWeek) {
        this.daysofweek = daysOfWeek;
    }
}
