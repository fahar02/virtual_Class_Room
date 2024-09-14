package com.jsp.virtualClassroom.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.virtualClassroom.dto.Trainer;

public interface TrainerRepo extends JpaRepository<Trainer,Integer> 
{
@Query("select t from trainer t where t.trainerEmail=?1")
public Optional<Trainer> findByEmail(String eamil);
}
