package com.realengagement.homeschool.jpa.repositories;

import java.util.List;

import com.realengagement.homeschool.jpa.entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
    List<Users> findByFullName(String fullName);
    List<Users> findByClassesId(long classesId);
    Users findById(long id);
    
    List<Users> findByClassesIdAndRoleId(Long classesId, Long roleId);
	List<Users> findByIdIn(List<Long> authorIdList); 
}
