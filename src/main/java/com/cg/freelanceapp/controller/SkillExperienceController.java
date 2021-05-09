package com.cg.freelanceapp.controller;
/**************************************************************************************
 * @author Amruth N 
 * Description: This is the rest controller class for SkillExperience module. 
 * Created Date: 22 April, 2021 
 * Version : v1.0.0
 *************************************************************************************/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.freelanceapp.dto.SkillExperienceDTO;
import com.cg.freelanceapp.exceptions.IdNotFoundException;
import com.cg.freelanceapp.service.ISkillExperienceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("SkillExperience Controller")
@RestController
@RequestMapping("/SkillExperience")
public class SkillExperienceController {

	@Autowired
	ISkillExperienceService skillExperienceService;
	@ApiOperation(value = "Add skill")
	@PostMapping("/AddSkill")
	public ResponseEntity<Object> Addskill(@RequestBody SkillExperienceDTO skillexperienceDto) {
			 skillExperienceService.addSkill(skillexperienceDto);
			 return new ResponseEntity<>("Skill Saved.", HttpStatus.OK);
}

	@PutMapping("/updateSkillYears/{id}")
	public ResponseEntity<Object> updateSkillYears(@PathVariable Long id,@RequestBody Integer Years) {
		try {
			skillExperienceService.updateSkillYears(id, Years);
			return new ResponseEntity<>("Updated records successfully", HttpStatus.OK);
		}
				 catch (IdNotFoundException e) {
						throw new IdNotFoundException("Cannot find skillExperience with given id");
					}
				}
	@GetMapping("/getSkillExperience/{id}")
	public ResponseEntity<Object> getSkillExperience(@PathVariable Long id) {
		try {
			skillExperienceService.getSkillById(id);
			return new ResponseEntity<>(skillExperienceService.getSkillById(id), HttpStatus.OK);
		}
				 catch (IdNotFoundException e) {
						throw new IdNotFoundException("Cannot find skillExperience with given id");
					}
				}
}