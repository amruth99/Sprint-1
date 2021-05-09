package com.cg.freelanceapp.entities;
/**************************************************************************************
 * @author       Amruth N
 * Description : This is the entity class for SkillExperience module. 
 * Created Date: 21 April, 2021 
 * Version     : v1.0.0
 *************************************************************************************/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity


public class SkillExperience {

	@Id
	@Column(name="skill_exp_id")
	@SequenceGenerator(name = "hibernate_seq", sequenceName = "hibernate_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_seq")
	Long id;

	@OneToOne
	@NotNull(message="Skill id should not be empty.")
	@JoinColumn(name = "skill_id")
	Skill skill;
	
	@NotNull(message="Years should not be empty.")
	@Column(name = "Skill_Years")
	Integer years;
	

	@NotNull(message = "Freelancer id should not be empty.")
	@ManyToOne(targetEntity = Freelancer.class)
	@JoinColumn(name = "freelancer_id")
	Freelancer freelancer;

	public SkillExperience() {
		super();
	}

	public SkillExperience(Long id, Skill skill, Integer years, Freelancer freelancer) {
		super();
		this.id = id;
		this.skill = skill;
		this.years = years;
		this.freelancer = freelancer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

}