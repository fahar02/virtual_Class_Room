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
public class Students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentsId;
	private String studentName;
	private String studentEmail;
	private String studentPassword;
	@ManyToOne
	@JoinColumn
	private Trainer trainer;
	@OneToMany(mappedBy = "students")
	private List<Courses> courses;
	@Override
	public String toString() {
		return "Students [studentsId=" + studentsId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentPassword=" + studentPassword + ", trainer=" + trainer + ", courses=" + courses + "]";
	}
	
	

}
