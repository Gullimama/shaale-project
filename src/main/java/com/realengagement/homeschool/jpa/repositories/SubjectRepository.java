package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    List<Subject> findBySubjectName(String subjectName);
    List<Subject> findByClassesId(long classesId);
    Subject findById(long id);
}
