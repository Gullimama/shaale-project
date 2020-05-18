package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Leavestatus;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface LeavestatusRepository extends CrudRepository<Leavestatus, Long> {
    Leavestatus findById(long id);
}
