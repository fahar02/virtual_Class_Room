package com.jsp.virtualClassroom.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentNotFoundException extends RuntimeException {
private String message;
}
