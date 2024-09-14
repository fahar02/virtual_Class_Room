package com.jsp.virtualClassroom.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int coursesId;
	private String courseName;
	@OneToMany(mappedBy = "courses")
	private List<Notes> notes;
	@ManyToOne
	@JoinColumn
	private Trainer trainer;
	@ManyToOne
	@JoinColumn
	private Students students;
	@Override
	public String toString() {
		return "Courses [coursesId=" + coursesId + ", courseName=" + courseName + ", notes=" + notes + ", trainer="
				+ trainer + ", students=" + students + "]";
	}

}
