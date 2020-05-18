package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Timetable;
import com.realengagement.homeschool.jpa.entities.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimetableRepository extends CrudRepository<Timetable, Long> {
    List<Timetable> findByClassesId(long classId);
    List<Timetable> findBySubjectId(long subjectId);
    List<Timetable> findByPeriodId(long periodId);
    Timetable findById(long id);
}
