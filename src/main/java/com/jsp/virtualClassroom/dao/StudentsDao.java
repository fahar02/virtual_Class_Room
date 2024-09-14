package com.jsp.virtualClassroom.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.virtualClassroom.dto.Students;
import com.jsp.virtualClassroom.repo.StudentsRepo;

@Repository
public class StudentsDao {
	@Autowired
	private StudentsRepo repo;
	public Students studentsSave(Students students) {
		return repo.save(students);
		
		
	}
	public Students saveStudents(int studentsId)
	{
		Optional<Students> optional=repo.findById(studentsId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		
		return null;
	}
	public Students loginStudents(String email) {
		
		Optional<Students> optional=repo.findByEmail(email);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	public Students studentsDelete(int studentId) {
		
		Optional<Students> optional=repo.findById(studentId);
		if(optional.isPresent())
		{
			repo.delete(optional.get());
			return optional.get();
		}
		
		return null;
	}

}
