package com.realengagement.homeschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Users;
import com.realengagement.homeschool.models.aggregates.TimetableAggregate;
import com.realengagement.homeschool.services.TimetableService;

@Controller
public class TimetableController {

    @Autowired
    TimetableService ttService;

    @RequestMapping("/timetable/user/{userId}")
    @ResponseBody
    public TimetableAggregate getTimeTableForSubjectTeacher(@PathVariable Long userId) {
        return ttService.getTimetable(new Users(userId));
    }

    @RequestMapping("/timetable/class/{classesId}")
    @ResponseBody
    public TimetableAggregate getTimetableForClass(@PathVariable Long classesId) {
        return ttService.getTimetable(new Classes(classesId));
    }
}
