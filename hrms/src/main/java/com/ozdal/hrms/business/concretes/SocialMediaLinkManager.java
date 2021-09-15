package com.ozdal.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozdal.hrms.business.abstracts.SocialMediaLinkService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.core.utilities.results.SuccessDataResult;
import com.ozdal.hrms.core.utilities.results.SuccessResult;
import com.ozdal.hrms.dataAccess.abstracts.SocialMediaLinkDao;
import com.ozdal.hrms.entities.concretes.SocialMediaLink;

@Service
public class SocialMediaLinkManager implements SocialMediaLinkService{

	private SocialMediaLinkDao socialMediaLinkDao;

	@Autowired
	public SocialMediaLinkManager(SocialMediaLinkDao socialMediaLinkDao) {
		this.socialMediaLinkDao = socialMediaLinkDao;
	}

	@Override
	public DataResult<List<SocialMediaLink>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<SocialMediaLink>>(this.socialMediaLinkDao.getByCandidateId(candidateId), "Sosyal medyaları getirildi");
	}

	@Override
	public Result addSocialMedaiLink(SocialMediaLink socialMediaLink) {
		this.socialMediaLinkDao.save(socialMediaLink);
		return new SuccessResult("Sosyal medya(lar) eklendi...");
	}
	
	
	
	
}
