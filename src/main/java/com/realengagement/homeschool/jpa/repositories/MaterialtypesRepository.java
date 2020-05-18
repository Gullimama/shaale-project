package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Materialtypes;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface MaterialtypesRepository extends CrudRepository<Materialtypes, Long> {
    Materialtypes findById(long id);
}
