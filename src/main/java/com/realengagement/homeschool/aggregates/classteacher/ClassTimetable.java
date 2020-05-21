package com.realengagement.homeschool.aggregates.classteacher;

import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Daysofweek;
import com.realengagement.homeschool.jpa.entities.Period;
import com.realengagement.homeschool.jpa.entities.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ClassTimetable {

    private Classes classes;
    private List<Daysofweek> daysofweek;
    private List<Period> periods;
    private List<Subject> subjects;
    private List<com.realengagement.homeschool.jpa.entities.Timetable> timetables;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
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

    public List<com.realengagement.homeschool.jpa.entities.Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<com.realengagement.homeschool.jpa.entities.Timetable> timetables) {
        this.timetables = timetables;
    }

    public void setDaysOfWeek(List<Daysofweek> daysOfWeek) {
        this.daysofweek = daysOfWeek;
    }
}
