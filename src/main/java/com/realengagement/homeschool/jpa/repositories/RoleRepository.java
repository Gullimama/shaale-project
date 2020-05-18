package com.realengagement.homeschool.jpa.repositories;

import com.realengagement.homeschool.jpa.entities.Role;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findByname(String name);
    Role findById(long id);
}
