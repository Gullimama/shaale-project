package com.realengagement.homeschool.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Classes;

@Component
public interface ClassesRepository extends CrudRepository<Classes, Long> {
    Classes findById(long id);
    List<Classes> findByIdIn(List<Long> id);
    List<Classes> findByClassesNo(Long classesNo);
    List<Classes> findByClassesNoAndSectionName(Long classesNo, String sectionName);
    List<Classes> findBySectionName(String sectionName);
}
