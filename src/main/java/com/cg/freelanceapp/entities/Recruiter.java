package com.cg.freelanceapp.entities;
/**************************************************************************************
 * @author       Amruth N
 * Description : This is the entity class for Recruiter module. 
 * Created Date: 20 April, 2021 
 * Version     : v1.0.0
 *************************************************************************************/
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recruiter {

	@Id
	@Column(name = "recruiter_id")
	Long id;

	String firstName;
	String lastName;

	@OneToMany(mappedBy = "postedBy", targetEntity = Job.class)
	List<Job> postedJobs;

	@OneToMany(mappedBy = "createdBy", targetEntity = Feedback.class)
	List<Feedback> feedbacks;

	@OneToMany
	List<BookmarkedFreelancer> freelancers;

	public Recruiter() {
		super();
	}

	public Recruiter(Long id, String firstName, String lastName, List<Job> postedJobs, List<Feedback> feedbacks,
			List<BookmarkedFreelancer> freelancers) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.postedJobs = postedJobs;
		this.feedbacks = feedbacks;
		this.freelancers = freelancers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Job> getPostedJobs() {
		return postedJobs;
	}

	public void setPostedJobs(List<Job> postedJobs) {
		this.postedJobs = postedJobs;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<BookmarkedFreelancer> getFreelancers() {
		return freelancers;
	}

	public void setFreelancers(List<BookmarkedFreelancer> freelancers) {
		this.freelancers = freelancers;
	}

}