package com.ozdal.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import com.ozdal.hrms.entities.concretes.Candidate;



public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	
	
	 

}
