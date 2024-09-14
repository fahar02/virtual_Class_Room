package com.jsp.virtualClassroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.virtualClassroom.dao.AdminstratorDao;
import com.jsp.virtualClassroom.dao.TrainerDao;
import com.jsp.virtualClassroom.dto.Adminstrator;
import com.jsp.virtualClassroom.dto.Trainer;
import com.jsp.virtualClassroom.exception.AdmintratorNotFoundException;
import com.jsp.virtualClassroom.exception.TrainerNotFoundException;
import com.jsp.virtualClassroom.util.ResponseStructure;

@Service
public class TrainerService {
	@Autowired
	private AdminstratorDao adminDao;
	@Autowired
	private TrainerDao dao;

	public ResponseEntity<ResponseStructure<Adminstrator>> saveTrainer(int adminId,Trainer trainer)
	{
		Adminstrator adminstrator=adminDao.adminstratorFind(adminId);
		if(adminstrator!=null)
		{
			trainer.setAdminstrator(adminstrator);
			Trainer dbTrainer=dao.trainerSave(trainer);
			ResponseStructure<Adminstrator> structure=new ResponseStructure();
			structure.setMessage("trainer save successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbTrainer);
			return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.CREATED);
		}
		else
		{
		throw new AdmintratorNotFoundException("Adminstrator not found");
		}
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> findTrainer(int trainerId) 
	{
		Trainer trainer=dao.trainerFind(trainerId);
		if(trainer!=null)
		{
			ResponseStructure<Adminstrator> structure=new ResponseStructure();
			structure.setMessage("trainer save successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(trainer);
			return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.CREATED);
		}
		else {
			throw new TrainerNotFoundException("trainer not found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> loginTrainer(String email, String password) 
	{
		Trainer trainer=dao.trainerFindEmail(email);
		return null;
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> deleteTrainer(int trainerId) 
	{
		Trainer trainer=dao.trainerDelete(trainerId);
		if(trainer!=null)
		{
			ResponseStructure<Adminstrator> structure=new ResponseStructure();
			structure.setMessage("trainer save successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(trainer);
			return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.CREATED);
		}
		else {
			throw new TrainerNotFoundException("trainer not found");
		}
		
	}

}
