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
import com.jsp.virtualClassroom.dto.Trainer;
import com.jsp.virtualClassroom.service.TrainerService;
import com.jsp.virtualClassroom.util.ResponseStructure;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
	@Autowired
	private TrainerService service;
	
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> save(@RequestParam int adminId,@RequestBody Trainer trainer)
	{
		return service.saveTrainer(adminId,trainer);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> find(@RequestParam int trainerId)
	{
		return service.findTrainer(trainerId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> login(@RequestParam String email,@RequestParam String password)
	{
		return service.loginTrainer(email,password);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> login(@RequestParam int trainerId)
	{
		return service.deleteTrainer(trainerId);
	}
	

}
