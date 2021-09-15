package com.ozdal.hrms.entities.concretes;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ozdal.hrms.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","businessExperiencies","schools","picture","socialMedias"})
public class Candidate  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_year")
	private int birthYear;
	
	
	@OneToMany(mappedBy="candidate")
    private List<School> schools;
	
	
	@OneToMany(mappedBy="candidate")
	private List<BusinessExperience> businessExperiencies;
	
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
	private List<SocialMediaLink> socialMedias;
	
	
	@OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
	private ProfilePicture picture;
	
	@OneToOne(mappedBy = "candidate",cascade=CascadeType.ALL)
	private CoverLetter coverLetter;
	
	@OneToOne()
	@JoinColumn(name="user_id")
	private User user;
	
}