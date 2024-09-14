package com.jsp.virtualClassroom.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdmintratorNotFoundException extends RuntimeException{
private String messageString;
}
