package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Chapter;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.List;

@Component
public interface ChapterRepository extends CrudRepository<Chapter, Long> {
    Chapter findById(long id);
}
