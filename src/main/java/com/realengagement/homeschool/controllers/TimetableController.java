package com.realengagement.homeschool.controllers;

import com.realengagement.homeschool.aggregates.classteacher.ClassTimetable;
import com.realengagement.homeschool.aggregates.classteacher.TeacherTimetable;
import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Timetable;
import com.realengagement.homeschool.jpa.entities.Users;
import com.realengagement.homeschool.services.timetable.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TimetableController {

    @Autowired
    TimetableService ttService;

    @RequestMapping("/time-table/user/{userId}")
    @ResponseBody
    public TeacherTimetable getTimeTableForSubjectTeacher(@PathVariable Long userId) {
        return ttService.getTimeTable(new Users(userId));
    }

    @RequestMapping("/time-table/class/{classesId}")
    @ResponseBody
    public ClassTimetable getTimeTableForClass(@PathVariable Long classesId) {
        return ttService.getTimeTable(new Classes(classesId));
    }
}
