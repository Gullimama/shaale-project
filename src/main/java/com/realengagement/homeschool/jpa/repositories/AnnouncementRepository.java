package com.realengagement.homeschool.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Announcement;

@Component
public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
    Announcement findById(long id);

	List<Announcement> findByClassesId(Long classesId);

	List<Announcement> findByAuthorId(Long authorId);
}
