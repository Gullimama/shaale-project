package com.realengagement.homeschool.jpa.repositories;

import java.sql.Time;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Period;

@Component
public interface PeriodRepository extends CrudRepository<Period, Long> {
    Period findById(long id);
    List<Period> findByIdIn(List<Long> ids);
    List<Period> findByStartTimeAndEndTime(Time startTime, Time endTime);
    List<Period> findByClassesId(Long classesId);
//    List<Period> findByClassesIdAndSubjectIdIn(Long classesId, List<Long> subjectIds); 
}
