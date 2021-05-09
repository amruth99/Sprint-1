package com.cg.freelanceapp.exceptions;
/**************************************************************************************
 * @author Amruth N 
 * Description: This is the GlobalExceptions class for IdNotFoundException. 
 * Created Date: 22 April, 2021 
 * Version : v1.0.0
 *************************************************************************************/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleException(IdNotFoundException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
