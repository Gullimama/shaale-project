package com.realengagement.homeschool.models.aggregates;

import com.realengagement.homeschool.jpa.entities.*;

import java.util.List;

public class TeacherTimetable {

    private List<Daysofweek> daysofweek;
    private List<Period> periods;
    private List<Subject> subjects;
    private List<Classes> classes;
    private List<Timetable> timetables;

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

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public List<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<Timetable> timetables) {
        this.timetables = timetables;
    }
}
