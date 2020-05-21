package com.realengagement.homeschool.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classes {

    public Classes() {}
    public Classes(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long classesNo;
    private String sectionName;

    public Long getId() {
        return id;
    }

    public Long getClassesNo() {
        return classesNo;
    }

    public void setClassesNo(Long classesNo) {
        this.classesNo = classesNo;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

}
