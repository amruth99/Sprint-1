package com.cg.freelanceapp.exceptions;
/**************************************************************************************
 * @author Amruth N 
 * Description: This is the Exceptions class for Skill and SkillExperience module. 
 * Created Date: 22 April, 2021 
 * Version : v1.0.0
 *************************************************************************************/
public class IdNotFoundException extends RuntimeException {
public IdNotFoundException() {
	
}
public IdNotFoundException(String msg)
{
	super(msg);
}
}
