package com.realengagement.homeschool.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.realengagement.homeschool.jpa.entities.Leave;
import com.realengagement.homeschool.jpa.entities.Users;

public interface LeaveRepository extends CrudRepository<Leave, Long> {
    Leave findById(long id);
    List<Leave> findByReferenceIdIn(List<Long> userIds); 
}
