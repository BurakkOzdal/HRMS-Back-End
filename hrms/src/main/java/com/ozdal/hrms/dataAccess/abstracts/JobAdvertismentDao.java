package com.ozdal.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozdal.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertismentDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> findByStatusTrue();
	List<JobAdvertisement> getByEmployer_id(int employerId);

}
