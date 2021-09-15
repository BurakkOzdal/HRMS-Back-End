package com.ozdal.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozdal.hrms.entities.concretes.SocialMediaLink;

public interface SocialMediaLinkDao extends JpaRepository<SocialMediaLink, Integer>{

	List<SocialMediaLink> getByCandidateId(int candidateId);
}
