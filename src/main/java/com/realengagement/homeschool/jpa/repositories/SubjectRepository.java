package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubjectRepository extends CrudRepository<Subject, Long> {
    List<Subject> findBySubjectName(String subjectName);
    List<Subject> findByClassesId(Long classesId);
    Subject findById(long id);
    List<Subject> findByIdIn(List<Long> id);
}
