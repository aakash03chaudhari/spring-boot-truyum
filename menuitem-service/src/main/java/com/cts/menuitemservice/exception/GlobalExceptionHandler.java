package com.cts.menuitemservice.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MenuItemNotFoundException.class)
	public String handleSweetItemNotFoundException(MenuItemNotFoundException e,HttpServletResponse response)
	{
		//please change it
		return "Menu Item Not Found "+e.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleArgumentNotValid(MethodArgumentNotValidException e,HttpServletResponse response) {
		Map<String,String> errors= new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String errorMessage=error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
