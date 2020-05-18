package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Material;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface MaterialRepository extends CrudRepository<Material, Long> {
    Material findById(long id);
}
