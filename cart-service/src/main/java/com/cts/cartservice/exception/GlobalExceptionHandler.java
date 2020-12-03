package com.cts.cartservice.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public String handleFeignException(FeignException e,HttpServletResponse response)
	{
		
		response.setStatus(e.status());
		return "MenuItem Not Found";
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
	
	
	@ExceptionHandler(MenuItemNotFoundException.class)
	public String handleSweetItemNotFoundException(MenuItemNotFoundException e,HttpServletResponse response)
	{
		
		return "MenuItem Not Found";
	}
	
	@ExceptionHandler(CartNotFoundException.class)
	public String handleCartNotFoundException(CartNotFoundException e,HttpServletResponse response)
	{
		return "Cart Not Found";
	}
}
