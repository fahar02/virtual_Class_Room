package com.jsp.virtualClassroom.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.virtualClassroom.dto.Adminstrator;
import com.jsp.virtualClassroom.dto.Courses;
import com.jsp.virtualClassroom.util.ResponseStructure;

@Service
public class CoursesService {

	public ResponseEntity<ResponseStructure<Adminstrator>> saveCourses(int trainerId, Courses courses) {
		
		return null;
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> findCourses(int coursesId) {
		
		return null;
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> deleteStudent(int coursesId) {
		
		return null;
	}

}
