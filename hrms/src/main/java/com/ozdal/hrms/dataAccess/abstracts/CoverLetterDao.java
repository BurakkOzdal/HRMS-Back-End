package com.ozdal.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozdal.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{
	
	CoverLetter getByCandidateId(int candidateId);

}
