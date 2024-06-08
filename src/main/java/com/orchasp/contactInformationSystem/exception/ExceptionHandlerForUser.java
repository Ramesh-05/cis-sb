package com.orchasp.contactInformationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orchasp.contactInformationSystem.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandlerForUser extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ResponseStructure<String>> StudentNotFound(UserNotFound ex) {
		ResponseStructure<String> m = new ResponseStructure<String>();
		m.setData("not found for user id");
		m.setMessage(ex.getMsg());
		m.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(m, HttpStatus.NOT_FOUND);
	}
}
