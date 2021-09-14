package com.ozdal.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="profile_pictures")
public class ProfilePicture {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="picture_url")
	@NotNull
	@NotBlank
	private String pictureUrl;
	
	@Column(name="public_id")
	private String publicId;
	
	@OneToOne()
	@JoinColumn(name="candidate_id",referencedColumnName = "id")
	private Candidate candidate;
}
