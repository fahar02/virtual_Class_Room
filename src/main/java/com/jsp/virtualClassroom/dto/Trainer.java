package com.jsp.virtualClassroom.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainerId;
	private String trainerName;
	private String trainerEmail;
	private String trainerPassword;
	@OneToMany(mappedBy ="trainer")
	private List<Students>  students;
	@OneToMany(mappedBy ="trainer")
	private List<Courses> courses;
	@ManyToOne
	private Adminstrator adminstrator;

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", trainerEmail=" + trainerEmail
				+ ", trainerPassword=" + trainerPassword + ", students=" + students + ", courses=" + courses
				+ ", adminstrator=" + adminstrator + "]";
	}
	
	
	
}
