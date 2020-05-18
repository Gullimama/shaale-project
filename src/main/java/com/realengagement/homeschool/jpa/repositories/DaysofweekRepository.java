package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Daysofweek;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface DaysofweekRepository extends CrudRepository<Daysofweek, Long> {
    Daysofweek findById(long id);
}
