package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Archivedclasses;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface ArchivedclassesRepository extends CrudRepository<Archivedclasses, Long> {
    Archivedclasses findById(long id);
}
