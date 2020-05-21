package com.realengagement.homeschool.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long dayId;
    private Long classesId;
    private Long subjectId;
    private Long periodId;
    private Long teachingId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Long teachingId) {
        this.teachingId = teachingId;
    }

    public Long getId() {
        return id;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }
}
