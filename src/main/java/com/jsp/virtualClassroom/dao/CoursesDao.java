package com.jsp.virtualClassroom.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.virtualClassroom.dto.Adminstrator;
import com.jsp.virtualClassroom.dto.Courses;
import com.jsp.virtualClassroom.service.CoursesService;
import com.jsp.virtualClassroom.util.ResponseStructure;

@Repository
@RequestMapping("/course")
public class CoursesDao {
	@Autowired
	private CoursesService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> save(@RequestParam int trainerId,@RequestBody Courses courses)
	{
		return service.saveCourses(trainerId,courses);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> find(@RequestParam int coursesId)
	{
		return service.findCourses(coursesId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> delete(@RequestParam int coursesId)
	{
		return service.deleteStudent(coursesId);
	}
	
	
	

}
