package com.jsp.virtualClassroom.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.virtualClassroom.dto.Students;

public interface StudentsRepo extends JpaRepository<Students,Integer> {
	@Query("select s from Students s where s.studentsEmail=?1")
	public Optional<Students> findByEmail(String email);

}
