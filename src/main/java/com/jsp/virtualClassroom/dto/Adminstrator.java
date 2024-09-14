package com.jsp.virtualClassroom.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Adminstrator {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	@Override
	public String toString() {
		return "Adminstrator [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", adminPassword=" + adminPassword + "]";
	}
	

}
