package com.jsp.virtualClassroom.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.virtualClassroom.dto.Adminstrator;

public interface AdminstrotorRepo extends JpaRepository<Adminstrator,Integer>{
	@Query("select e from Adminstrator e where e.adminstratorEmail=?1")
	Optional<Adminstrator>findByEmail(String email);

}
