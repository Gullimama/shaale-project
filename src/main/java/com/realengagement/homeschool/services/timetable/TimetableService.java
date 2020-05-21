package com.realengagement.homeschool.services.timetable;

import com.realengagement.homeschool.aggregates.classteacher.ClassTimetable;
import com.realengagement.homeschool.aggregates.classteacher.TeacherTimetable;
import com.realengagement.homeschool.jpa.entities.*;
import com.realengagement.homeschool.jpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public TeacherTimetable getTimeTable(Users user) {
        TeacherTimetable timetable = new TeacherTimetable();

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
                .map(teaching -> teaching.getClassesId())
                .collect(Collectors.toList());

        List<com.realengagement.homeschool.jpa.entities.Timetable> timetableEntities = timetableRepository.findByTeachingIdIn(teachingsIds);
        List<Daysofweek> daysOfWeek = (List<Daysofweek>) daysofweekRepository.findAll();

        List<Long> periodIds = timetableEntities
                .stream()
                .map(timetableEntity -> timetableEntity.getPeriodId())
                .collect(Collectors.toList());

        List<Classes> classes = classesRepository.findByIdIn(classesIds);
        List<Subject> subjects = subjectRepository.findByIdIn(subjectIds);
        List<Period> periods = periodRepository.findByIdIn(periodIds);

        timetable.setClasses(classes);
        timetable.setDaysofweek(daysOfWeek);
        timetable.setPeriods(periods);
        timetable.setSubjects(subjects);
        timetable.setTimetables(timetableEntities);

        return timetable;
    }

    public ClassTimetable getTimeTable(Classes classes) {
        ClassTimetable timetable = new ClassTimetable();

        List<Daysofweek> daysOfWeek = (List<Daysofweek>) daysofweekRepository.findAll();
        List<Period> periods = (List<Period>) periodRepository.findByClassesId(classes.getId());
        List<Subject> subjects = (List<Subject>) subjectRepository.findByClassesId(classes.getId());
        List<com.realengagement.homeschool.jpa.entities.Timetable> timetableEntities = timetableRepository.findByClassesId(classes.getId());

        timetable.setDaysOfWeek(daysOfWeek);
        timetable.setSubjects(subjects);
        timetable.setPeriods(periods);
        timetable.setTimetables(timetableEntities);
        timetable.setClasses(classesRepository.findById((long) classes.getId()));

        return timetable;
    }

}
