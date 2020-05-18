package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Period;
import com.realengagement.homeschool.jpa.entities.Teaching;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface TeachingRepository extends CrudRepository<Teaching, Long> {
    Teaching findById(long id);
}
