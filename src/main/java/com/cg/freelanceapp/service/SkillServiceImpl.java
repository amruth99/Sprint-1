package com.cg.freelanceapp.service;
import java.util.List;

/****************************************************
 * Method :Skill
 * Method
 * @param skillDto
 * @throws  IdNotFoundException
 * Description: This method saves a skill
 ****************************************************/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.freelanceapp.dao.ISkillDao;
import com.cg.freelanceapp.dto.SkillDTO;
import com.cg.freelanceapp.entities.Skill;
import com.cg.freelanceapp.exceptions.IdNotFoundException;

@Service
public class SkillServiceImpl implements ISkillService {

	@Autowired
	ISkillDao skillDao;
	
	@Transactional
	@Override
	public Skill save(SkillDTO skillDto) {
		Skill skill = new Skill();
		skill.setDescription(skillDto.getDescription());
		skill.setName(skillDto.getName());
		
		return skillDao.save(skill);
	}

	@Override
	public Skill update(Long id, Skill skill) {
		if(skillDao.existsById(id)) {
			return skillDao.save(skill);
		}
		else {
			throw new IdNotFoundException();
		}
	}
    @Override
    public String remove(Long id) {
    	if(skillDao.existsById(id)) {
			skillDao.deleteById(id);
			return "Deleted";
		}
			else {
				throw new IdNotFoundException();
			}
    }

	@Override
	public Skill findById(Long id) {
		return skillDao.findById(id).get();
	}

	@Override
	public Skill save(Skill skill) {
		return skillDao.save(skill);
	}

	@Override
	public Skill getSkill(Long id) {
		return skillDao.getOne(id);
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillDao.findAll();
	}

	
}
