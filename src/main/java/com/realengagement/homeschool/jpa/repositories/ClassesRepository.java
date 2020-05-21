package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Classes;
import com.realengagement.homeschool.jpa.entities.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClassesRepository extends CrudRepository<Classes, Long> {
    Classes findById(long id);
    List<Classes> findByIdIn(List<Long> id);
    List<Classes> findByClassesNo(Long classesNo);
    List<Classes> findByClassesNoAndSectionName(Long classesNo, String sectionName);
    List<Classes> findBySectionName(String sectionName);
}
