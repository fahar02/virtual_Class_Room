package com.jsp.virtualClassroom.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.virtualClassroom.dto.Adminstrator;
import com.jsp.virtualClassroom.repo.AdminstrotorRepo;

@Repository
public class AdminstratorDao {
	
	@Autowired
	private AdminstrotorRepo repo;

	public Adminstrator adminstrator(Adminstrator adminstrator) {
		return repo.save(adminstrator);
	}

	public Adminstrator adminstratorLogin(String email, String password)
	{
		Optional<Adminstrator> optional=repo.findByEmail(email);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	public Adminstrator adminstratorDelate(int adminstratorId) 
	{
		Optional<Adminstrator> optional=repo.findById(adminstratorId);
		if(optional.isPresent())
		{
			repo.delete(optional.get());
			return optional.get();
		}
		return null;
	}

	public Adminstrator adminstratorFind(int adminstratorId) 
	{
		Optional<Adminstrator> optional=repo.findById(adminstratorId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

}
