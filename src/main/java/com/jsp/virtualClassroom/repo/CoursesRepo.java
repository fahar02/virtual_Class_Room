package com.jsp.virtualClassroom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.virtualClassroom.dto.Courses;

public interface CoursesRepo extends JpaRepository<Courses,Integer> {

}
