package com.jsp.virtualClassroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.virtualClassroom.dto.Adminstrator;
import com.jsp.virtualClassroom.dto.Students;
import com.jsp.virtualClassroom.service.StudentsService;
import com.jsp.virtualClassroom.util.ResponseStructure;

@RestController
@RequestMapping("/student")
public class StudentsController {
	
	@Autowired
	private StudentsService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> save(@RequestParam int trainerId,@RequestBody Students students)
	{
		return service.saveStudent(trainerId,students);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> find(@RequestParam int studentsId)
	{
		return service.findStudent(studentsId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> login(@RequestParam String email,@RequestParam String password)
	{
		return service.loginStudent(email,password);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> delete(@RequestParam int studentId)
	{
		return service.deleteTrainer(studentId);
	}

}
