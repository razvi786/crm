package com.cts.crm.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomExceptionResponse {
	
	private Date timestamp;
	private String message;
	private String details;

}
