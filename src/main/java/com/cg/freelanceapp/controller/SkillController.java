package com.cg.freelanceapp.controller;

import java.util.List;

/**************************************************************************************
 * @author Amruth N 
 * Description: This is the rest controller class for Skill module. 
 * Created Date: 22 April, 2021 
 * Version : v1.0.0
 *************************************************************************************/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.freelanceapp.dto.SkillDTO;
import com.cg.freelanceapp.entities.Skill;
import com.cg.freelanceapp.exceptions.IdNotFoundException;
import com.cg.freelanceapp.service.ISkillService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@Api("Skill Controller")
@RestController
@RequestMapping("/SkillApi")
public class SkillController {
	@Autowired
	ISkillService skillservice;
	@ApiOperation(value = "Save a skill")
	@PostMapping("/SkillSave")
	public ResponseEntity<Object> saveskill(@RequestBody SkillDTO skillDto) {
			skillservice.save(skillDto);
			return new ResponseEntity<>("Skill Saved.", HttpStatus.OK);
		}
	
	@DeleteMapping(value = "/removeSkill/{id}")
	public ResponseEntity<Object> Deleteskill(@PathVariable Long id) {
		try {
			skillservice.remove(id);
			return new ResponseEntity<>("Deleted Skill Successfully.", HttpStatus.OK);
}
		catch (IdNotFoundException e) {
			throw new IdNotFoundException("Cannot find skill with given id.");
		}
	}
	
	@PostMapping("/updateSkill/{id}")
	public ResponseEntity<Object> updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
		try {
			skillservice.update(id,skill);
			return new ResponseEntity<>("Updated records successfully", HttpStatus.OK);
}
		 catch (IdNotFoundException e) {
				throw new IdNotFoundException("Cannot find skill with given id");
			}
		}
	@GetMapping(value="/getAllSkill")
	public List<Skill> getAllSkill()
	{
		return skillservice.getAllSkills();
	}
}
