package com.jsp.virtualClassroom.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TrainerNotFoundException extends RuntimeException {
private String message;
}
