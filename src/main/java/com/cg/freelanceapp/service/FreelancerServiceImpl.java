package com.cg.freelanceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.freelanceapp.dao.IFreelancerDao;
import com.cg.freelanceapp.dto.FreelancerDTO;
import com.cg.freelanceapp.entities.Freelancer;

/**************************************************************************************
 * @author       Amruth N 
 * Description : This is the Service Implementation for Freelancer module. 
 * Created Date: 21 April, 2021 
 * Version     : v1.0.0
 *************************************************************************************/
@Service
public class FreelancerServiceImpl implements IFreelancerService {

	@Autowired
	IFreelancerDao freelancerDao;

	@Transactional
	@Override
	public Freelancer findById(Long id) {
		return freelancerDao.findById(id).get();
	}

	@Override
	public Freelancer save(FreelancerDTO freelancerDto) {
		Freelancer freelancer = new Freelancer();
		freelancer.setFirstName(freelancerDto.getFirstName());
		freelancer.setLastName(freelancerDto.getLastName());
		freelancer.setPassword(freelancerDto.getPassword());
		return freelancerDao.save(freelancer);
	}

	@Override
	public Freelancer update(Freelancer freelancer) {
		return freelancerDao.save(freelancer);
	}

}