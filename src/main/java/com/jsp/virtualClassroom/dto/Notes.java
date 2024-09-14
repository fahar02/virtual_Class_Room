package com.jsp.virtualClassroom.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Notes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int notesId;
	private String notesTitle;
	@ManyToOne
	@JoinColumn
	private Courses courses;
	@Override
	public String toString() {
		return "Notes [notesId=" + notesId + ", notesTitle=" + notesTitle + ", courses=" + courses + "]";
	}
}
