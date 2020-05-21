package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.List;

@Component
public interface PeriodRepository extends CrudRepository<Period, Long> {
    Period findById(long id);
    List<Period> findByIdIn(List<Long> ids);
    List<Period> findByStartTimeAndEndTime(Time startTime, Time endTime);
    List<Period> findByClassesId(Long classesId);
}
