package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Leave;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface LeaveRepository extends CrudRepository<Leave, Long> {
    Leave findById(long id);
}
