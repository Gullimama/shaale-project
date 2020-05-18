package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Announcement;
import com.realengagement.homeschool.jpa.entities.Period;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.List;

public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
    Announcement findById(long id);
}
