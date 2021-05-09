package com.cg.freelanceapp.dao;
/**************************************************************************************
 * @author       Amruth N 
 * Description : This is the DAO Interface for Freelancer module. 
 * Created Date: 21 April, 2021 
 * Version     : v1.0.0
 *************************************************************************************/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.freelanceapp.entities.Freelancer;

@Repository
public interface IFreelancerDao extends JpaRepository<Freelancer, Long>{

}
