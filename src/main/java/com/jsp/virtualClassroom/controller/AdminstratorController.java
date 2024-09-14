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
import com.jsp.virtualClassroom.service.AdminstratorService;
import com.jsp.virtualClassroom.util.ResponseStructure;

@RestController
@RequestMapping("/Admin")
public class AdminstratorController {
	
	@Autowired
	private AdminstratorService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> save(@RequestBody Adminstrator adminstrator)
	{
		return service.saveAdminstratro(adminstrator);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> login(@RequestParam String email,@RequestParam String password)
	{
		return service.loginAdminstratro(email,password);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> find(@RequestParam int adminstratorId)
	{
		return service.findAdminstratro(adminstratorId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Adminstrator>> delete(@RequestParam int adminstratorId)
	{
		return service.delateAdminstratro(adminstratorId);
	}
	

}
