package com.ozdal.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithCandidateDto {
	
	private int id;
	private int userId;
	private String email;
	private String candidateFirstName;
	private String candidateLastName;
}
