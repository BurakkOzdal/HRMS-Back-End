package com.ozdal.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozdal.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

}
