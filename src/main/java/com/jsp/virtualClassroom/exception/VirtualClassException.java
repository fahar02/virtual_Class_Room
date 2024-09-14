package com.jsp.virtualClassroom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.virtualClassroom.util.ResponseStructure;

public class VirtualClassException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminIdNotFoundException(AdmintratorNotFoundException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("adminstrator not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleTrainerIdNotFoundException(TrainerNotFoundException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("trainer not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleStudentIdNotFoundException(StudentNotFoundException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("student not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
