package com.jsp.virtualClassroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.virtualClassroom.dao.StudentsDao;
import com.jsp.virtualClassroom.dao.TrainerDao;
import com.jsp.virtualClassroom.dto.Adminstrator;
import com.jsp.virtualClassroom.dto.Students;
import com.jsp.virtualClassroom.dto.Trainer;
import com.jsp.virtualClassroom.exception.StudentNotFoundException;
import com.jsp.virtualClassroom.exception.TrainerNotFoundException;
import com.jsp.virtualClassroom.util.ResponseStructure;

@Service
public class StudentsService {
	@Autowired
	private StudentsDao dao;
	@Autowired
	private TrainerDao tdao;

	public ResponseEntity<ResponseStructure<Adminstrator>> findStudent(int studentsId) {
		Students students=dao.saveStudents(studentsId);
		if(students!=null)
		{
			ResponseStructure<Adminstrator> structure=new ResponseStructure();
			structure.setMessage("students find successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(students);
			return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.OK);
		}
		else {
			throw new StudentNotFoundException("student not found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> loginStudent(String email, String password) {
		Students students=dao.loginStudents(email);
		if(students!=null)
		{
			if(students.getStudentPassword()==password)
			{
				ResponseStructure<Adminstrator> structure=new ResponseStructure();
				structure.setMessage("Student login successfully");
				structure.setHttpStatus(HttpStatus.OK.value());
				structure.setData(students);
				return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.OK);
			}
			else {
				throw new StudentNotFoundException("student not found");
			}
		}
		else {
			throw new StudentNotFoundException("student not found");
		}
		
		
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> deleteTrainer(int studentId) {
		Students students=dao.studentsDelete(studentId);
		if(students!=null)
		{
			ResponseStructure<Adminstrator> structure=new ResponseStructure();
			structure.setMessage("students delete successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(students);
			return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.OK);
		}
		else {
			throw new StudentNotFoundException("student not found");
		}
	}

	public ResponseEntity<ResponseStructure<Adminstrator>> saveStudent(int trainerId, Students students) 
	{
		Trainer trainer=tdao.trainerFind(trainerId);
		if(trainer!=null)
		{
			students.setTrainer(trainer);
		Students dbstudents=	dao.studentsSave(students);
			ResponseStructure<Adminstrator> structure=new ResponseStructure();
			structure.setMessage("Student save successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbstudents);
			return new ResponseEntity<ResponseStructure<Adminstrator>>(structure,HttpStatus.OK);
		}
		else {
			throw new TrainerNotFoundException("trainer not found");
		}
		
	}

}
