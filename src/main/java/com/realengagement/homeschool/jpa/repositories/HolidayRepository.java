package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Holiday;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface HolidayRepository extends CrudRepository<Holiday, Long> {
    Holiday findById(long id);
}
