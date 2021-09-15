package com.ozdal.hrms.business.abstracts;

import java.util.List;

import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.SocialMediaLink;

public interface SocialMediaLinkService {
	
	DataResult<List<SocialMediaLink>> getByCandidateId(int candidateId);
	Result addSocialMedaiLink(SocialMediaLink socialMediaLink);

}
