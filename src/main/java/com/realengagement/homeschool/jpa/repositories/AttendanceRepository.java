package com.realengagement.homeschool.jpa.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.realengagement.homeschool.jpa.entities.Attendance;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
    Attendance findById(long id);

    List<Attendance> findByUserIdAndDatedBetween(Long userId, Date startDate, Date endDate);

	List<Attendance> findByUserIdInAndDatedBetween(List<Long> userIdList, Date startDate, Date endDate);

	List<Attendance> findByUserIdInAndPeriodIdInAndDatedBetween(List<Long> classStudentIdList, List<Long> periodIdList,
			Date startDate, Date endDate); 
}
