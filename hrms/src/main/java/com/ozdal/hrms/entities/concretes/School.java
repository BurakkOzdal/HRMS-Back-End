package com.ozdal.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
public class School {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="school_name")
	private String schoolName;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="university_department")
	private String universityDepartment;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="started_date")
	private String startDate;
	
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="graduat_status")
	private boolean graduatedStatus;
	
	@Column(name="finished_date")
	private String finishDate;
	
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	
}
