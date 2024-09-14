package com.jsp.virtualClassroom.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jsp.virtualClassroom.dto.Notes;

public interface NotesRepo extends JpaRepository<Notes,Integer>
{

}
