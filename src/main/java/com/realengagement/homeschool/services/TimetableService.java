package com.realengagement.homeschool.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Daysofweek;
import com.realengagement.homeschool.jpa.entities.Period;
import com.realengagement.homeschool.jpa.entities.Subject;
import com.realengagement.homeschool.jpa.entities.Teaching;
import com.realengagement.homeschool.jpa.entities.Timetable;
import com.realengagement.homeschool.jpa.entities.Users;
import com.realengagement.homeschool.jpa.repositories.ClassesRepository;
import com.realengagement.homeschool.jpa.repositories.DaysofweekRepository;
import com.realengagement.homeschool.jpa.repositories.PeriodRepository;
import com.realengagement.homeschool.jpa.repositories.SubjectRepository;
import com.realengagement.homeschool.jpa.repositories.TeachingRepository;
import com.realengagement.homeschool.jpa.repositories.TimetableRepository;
import com.realengagement.homeschool.jpa.repositories.UsersRepository;
import com.realengagement.homeschool.models.aggregates.TimetableAggregate;

@Service
public class TimetableService {

    @Autowired
    TimetableRepository timetableRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    PeriodRepository periodRepository;

    @Autowired
    DaysofweekRepository daysofweekRepository;

    @Autowired
    TeachingRepository teachingRepository;

    @Autowired
    ClassesRepository classesRepository;
    
    @Autowired
    UsersRepository userRepository; 
    
    // For subject-teachers. 
    public TimetableAggregate getTimetable(Users user) {
        TimetableAggregate timetable = new TimetableAggregate();

        List<Teaching> teachings = teachingRepository.findByTeacherId(user.getId());
        
        List<Long> teachingsIds = teachings
                .stream()
                .map(teaching -> teaching.getId())
                .collect(Collectors.toList());

        List<Long> classesIds = teachings
                .stream()
                .map(teaching -> teaching.getClassesId())
                .collect(Collectors.toList());

        List<Long> subjectIds = teachings
                .stream()
                .map(teaching -> teaching.getSubjectId())
                .collect(Collectors.toList());

        List<Timetable> timetableEntities = timetableRepository.findByTeachingIdIn(teachingsIds);

        List<Long> periodIds = timetableEntities
                .stream()
                .map(timetableEntity -> timetableEntity.getPeriodId())
                .collect(Collectors.toList());

        List<Daysofweek> daysOfWeek = (List<Daysofweek>) daysofweekRepository.findAll();
        List<Classes> classes = classesRepository.findByIdIn(classesIds);
        List<Subject> subjects = subjectRepository.findByIdIn(subjectIds);
        List<Period> periods = periodRepository.findByIdIn(periodIds);

        timetable.setClasses(classes);
        timetable.setDaysofweek(daysOfWeek);
        timetable.setPeriods(periods);
        timetable.setSubjects(subjects);
        timetable.setTimetables(timetableEntities);
        timetable.setTeachings(teachings);

        return timetable;
    }

    public TimetableAggregate getTimetable(Classes classes) {
        TimetableAggregate timetable = new TimetableAggregate();
        
        List<Daysofweek> daysOfWeek = (List<Daysofweek>) daysofweekRepository.findAll();
        List<Period> periods = (List<Period>) periodRepository.findByClassesId(classes.getId());
        List<Subject> subjects = (List<Subject>) subjectRepository.findByClassesId(classes.getId());
        List<Timetable> timetableEntities = timetableRepository.findByClassesId(classes.getId());
        List<Teaching> teachings = teachingRepository.findByClassesId(classes.getId()); 
        List<Users> teachers = userRepository.findByIdIn(teachings.stream().map(teaching -> teaching.getTeacherId()).collect(Collectors.toList())); 
        
        timetable.setDaysOfWeek(daysOfWeek);
        timetable.setSubjects(subjects);
        timetable.setPeriods(periods);
        timetable.setTimetables(timetableEntities);
        timetable.setTeachers(teachers);
        timetable.setTeachings(teachings);
        timetable.setClasses(Arrays.asList(classesRepository.findById((long) classes.getId())));
        
        return timetable;
    }

}
