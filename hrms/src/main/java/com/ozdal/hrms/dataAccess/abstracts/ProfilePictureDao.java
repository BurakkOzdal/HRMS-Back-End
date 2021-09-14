package com.ozdal.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozdal.hrms.entities.concretes.ProfilePicture;

public interface ProfilePictureDao extends JpaRepository<ProfilePicture, Integer>{

	ProfilePicture getByCandidateId(int candidateId);
}
