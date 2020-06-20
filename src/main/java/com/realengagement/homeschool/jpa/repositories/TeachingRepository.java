package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Period;
import com.realengagement.homeschool.jpa.entities.Teaching;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.List;

@Component
public interface TeachingRepository extends CrudRepository<Teaching, Long> {
    Teaching findById(long id);

    List<Teaching> findByTeacherId(Long id);
    List<Teaching> findByTeacherIdAndClassesId(Long teacherId, Long classesId);
    List<Teaching> findByClassesId(Long classesId); 
}
