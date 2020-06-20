package com.realengagement.homeschool.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Archivedclasses;

@Component
public interface ArchivedclassesRepository extends CrudRepository<Archivedclasses, Long> {
    Archivedclasses findById(long id);

	List<Archivedclasses> findByClassesIdAndSubjectId(Long classesId, Long subjectId);
}
