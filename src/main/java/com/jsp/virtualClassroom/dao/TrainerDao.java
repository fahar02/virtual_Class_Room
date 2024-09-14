package com.jsp.virtualClassroom.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.virtualClassroom.dto.Trainer;
import com.jsp.virtualClassroom.repo.TrainerRepo;

@Repository
public class TrainerDao {
	@Autowired
	private TrainerRepo repo;

	public Trainer trainerSave(Trainer trainer) 
	{
		return repo.save(trainer);
		
	}

	public Trainer trainerFind(int trainerId) 
	{
		Optional<Trainer> optional=repo.findById(trainerId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	public Trainer trainerFindEmail(String email) {
		Optional<Trainer> optional=repo.findByEmail(email);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	public Trainer trainerDelete(int trainerId) {
		Optional<Trainer> optional=repo.findById(trainerId);
		if(optional.isPresent())
		{
			repo.delete(optional.get());
			return optional.get();
		}
		return null;
	}

}
