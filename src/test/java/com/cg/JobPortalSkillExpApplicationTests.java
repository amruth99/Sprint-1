package com.cg;
/**************************************************************************************
 * @author Amruth N 
 * Description: This is the JUNIT class for skill and skillExperience module. 
 * Created Date: 24 April, 2021 
 * Version : v1.0.0
 *************************************************************************************/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.freelanceapp.dao.ISkillDao;
import com.cg.freelanceapp.dao.ISkillExperienceDao;
import com.cg.freelanceapp.dto.SkillExperienceDTO;
import com.cg.freelanceapp.entities.Skill;
import com.cg.freelanceapp.exceptions.IdNotFoundException;
import com.cg.freelanceapp.service.ISkillExperienceService;
import com.cg.freelanceapp.service.ISkillService;

@SpringBootTest
class JobPortalSkillExpApplicationTests {
	@Autowired
	ISkillService skillService;
	
	@Autowired
	ISkillExperienceService skillExperienceService;
	
	@Autowired
	ISkillExperienceDao skillExperienceDao;	
	
	@Autowired
	ISkillDao skillDao;

	@Test
	/***********************************************
	 * Description: Testing the addSkill method
	 **********************************************/
	void testAddSkill() {
		
		Skill skill = new Skill("java", "java skill");
		skillService.save(skill);
		Long id = skillDao.getCurrentSeriesId();
		assertEquals("java skill", skillService.findById(id).getDescription());
		
		
	}
	@Test
	/***********************************************
	 *Description: Testing the RemoveSkill method
	 **********************************************/
	void testRemoveSkill() {      
		Long id = 286L;
		assertEquals("Deleted", skillService.remove(id));
	}
	
	@Test
	/********************************************************
	 *Description: Testing the RemoveSkill method Exception
	 *******************************************************/
	void testRemoveSkillException() {      
		Long id = 3L;
		assertThrows(IdNotFoundException.class,()->skillService.remove(id));
	}
	@Test
	/********************************************************
	 *Description: Testing the UpdateSkill method 
	 *******************************************************/
	void testUpdateSkill() {
		Long id = 42L;
		Skill skill2 = new Skill();
		skill2.setName("Python");
		skill2.setDescription("py skill");
		assertEquals( "Python", skillService.update(id, skill2).getName());
	}

	@Test
	/********************************************************
	 *Description: Testing the UpdateSkill method Exception
	 *******************************************************/
	void testUpdateSkillException() {
	Long id = 3L;
	Skill skill2 = new Skill();
	skill2.setName("Python");
	skill2.setDescription("py skill");
	assertThrows(IdNotFoundException.class,()->skillService.update(id, skill2));
	}

	@Test
	/********************************************************
	 *Description: Testing the AddSkillExperience method 
	 *******************************************************/
	void testAddSkillExperience() {
		SkillExperienceDTO skillExperiencedto = new SkillExperienceDTO();
		skillExperiencedto.setFreelancerId(144L);
		skillExperiencedto.setSkillId(142L);
		skillExperiencedto.setYears(13);
		assertEquals(13, skillExperienceService.addSkill(skillExperiencedto).getYears());
	}
	
	@Test
	/********************************************************
	 *Description: Testing the UpdateSkillExperience method 
	 *******************************************************/
	void testUpdateSkillExperience() {
	Long id = 146L;
	SkillExperienceDTO skillExperiencedto2 = new SkillExperienceDTO();
	skillExperiencedto2.setYears(13);
	skillExperienceService.updateSkillYears(id, 13);
	assertEquals(13, skillExperiencedto2.getYears());
	}
	
	@Test
	/********************************************************
	 *Description: Testing the UpdateSkillExperience method Exception
	 *******************************************************/
	void testUpdateSkillExperienceException() {
		Long id = 150L;
		assertThrows(IdNotFoundException.class,()->skillExperienceService.updateSkillYears(id, 13));
	}
	}