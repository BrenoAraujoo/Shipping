package com.shipping.exceptions.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ValidationExceptionsHandler{


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e){
		BindingResult br = e.getBindingResult();
		
		List<String> list = new ArrayList<>();
		StandardError err = new StandardError();
		
		br.getFieldErrors().forEach(errors ->{	
			err.getFieldError().add(errors.getDefaultMessage());
		});
		
		err.setError("Validation error");
		err.setMessage("Validation Message error:");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	
}
