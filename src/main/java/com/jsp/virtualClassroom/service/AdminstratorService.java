package com.jsp.virtualClassroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.virtualClassroom.dao.AdminstratorDao;
import com.jsp.virtualClassroom.dto.Adminstrator;
import com.jsp.virtualClassroom.exception.AdmintratorNotFoundException;
import com.jsp.virtualClassroom.util.ResponseStructure;

@Service
public class AdminstratorService {
	@Autowired
	private AdminstratorDao dao;

	public ResponseEntity<ResponseStructure<Adminstrator>> saveAdminstratro(Adminstrator adminstrator) 
	{
		Adminstrator dbAdminstrator=dao.adminstrator(adminstrator);
		ResponseStructure<Adminstrator> structure=new ResponseStructure();
		structure.setMessage("adminstrator save successfully");
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setData(dbAdminstrator);
		return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> loginAdminstratro(String email, String password)
	{
		Adminstrator dbAdminstrator=dao.adminstratorLogin(email,password);
		if(dbAdminstrator!=null)
		{
			if(dbAdminstrator.getAdminPassword()==password)
			{
				ResponseStructure<Adminstrator> structure=new ResponseStructure();
				structure.setMessage("adminstrator login successfully");
				structure.setHttpStatus(HttpStatus.OK.value());
				structure.setData(dbAdminstrator);
				return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.OK);
			}
			else {
				throw new AdmintratorNotFoundException("Adminstrator not found");
			}
			
		}
		else {
			throw new AdmintratorNotFoundException("Adminstrator not found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> delateAdminstratro(int adminstratorId) 
	{
		Adminstrator dbAdminstrator=dao.adminstratorDelate(adminstratorId);
		ResponseStructure<Adminstrator> structure=new ResponseStructure();
		structure.setMessage("adminstrator delete successfully");
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setData(dbAdminstrator);
		return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> findAdminstratro(int adminstratorId) 
	{
		
		Adminstrator dbAdminstrator=dao.adminstratorFind(adminstratorId);
		if(dbAdminstrator!=null)
		{
				ResponseStructure<Adminstrator> structure=new ResponseStructure();
				structure.setMessage("adminstrator login successfully");
				structure.setHttpStatus(HttpStatus.OK.value());
				structure.setData(dbAdminstrator);
				return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.OK);
			
		}
		else {
			throw new AdmintratorNotFoundException("Adminstrator not found");
		}
	}

}
