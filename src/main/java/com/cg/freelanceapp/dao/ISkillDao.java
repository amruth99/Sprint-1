package com.cg.freelanceapp.dao;
/**************************************************************************************
 * @author       Amruth N 
 * Description : This is the DAO Interface for Skill module. 
 * Created Date: 21 April, 2021 
 * Version     : v1.0.0
 *************************************************************************************/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.freelanceapp.entities.Skill;
@Repository
public interface ISkillDao extends JpaRepository<Skill, Long>{
	
	@Query(value = "select hibernate_id_seq.currval from dual", nativeQuery = true)
	 Long getCurrentSeriesId();
}
