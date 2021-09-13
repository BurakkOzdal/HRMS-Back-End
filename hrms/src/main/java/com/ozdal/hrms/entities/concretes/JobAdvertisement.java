package com.ozdal.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_description")
	private String jobDescription; 
	
	@Column(name="job_position")
	private String jobPosition; 
	
	@Column(name="open_position")
	private int openPosition; 
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="finish_date")
	private Date finishDate;
	
	@Column(name="status")
	private boolean status;
	
	
	@OneToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@OneToOne()
	@JoinColumn(name="city_id")
	private City city;
}
