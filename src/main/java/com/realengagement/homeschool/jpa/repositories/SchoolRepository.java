package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Period;
import com.realengagement.homeschool.jpa.entities.School;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface SchoolRepository extends CrudRepository<School, Long> {
    School findById(long id);
}
