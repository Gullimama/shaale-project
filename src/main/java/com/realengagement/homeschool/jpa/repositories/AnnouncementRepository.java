package com.realengagement.homeschool.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.realengagement.homeschool.jpa.entities.Announcement;

@Component
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    Announcement findById(long id);

	List<Announcement> findByClassesId(Long classesId);

	List<Announcement> findByAuthorId(Long authorId);
	
	
}
