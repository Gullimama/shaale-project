package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Timetable;
import com.realengagement.homeschool.jpa.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TimetableRepository extends CrudRepository<Timetable, Long> {
    List<Timetable> findByClassesId(Long classId);
    List<Timetable> findBySubjectId(Long subjectId);
    List<Timetable> findByPeriodId(Long periodId);
    List<Timetable> findByTeachingIdIn(List<Long> teachingId);
    Timetable findById(long id);
}
