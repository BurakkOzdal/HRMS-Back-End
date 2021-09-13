package com.ozdal.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozdal.hrms.entities.concretes.BusinessExperience;

public interface BusinessExperienceDao extends JpaRepository<BusinessExperience	, Integer>{

}
