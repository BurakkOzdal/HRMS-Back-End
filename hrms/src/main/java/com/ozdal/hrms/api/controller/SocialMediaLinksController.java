package com.ozdal.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozdal.hrms.business.abstracts.SocialMediaLinkService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.SocialMediaLink;

@RestController
@RequestMapping("/api/socialMedias")
public class SocialMediaLinksController {

	private SocialMediaLinkService socialMediaLinkService;
	
	@Autowired
	public SocialMediaLinksController(SocialMediaLinkService socialMediaLinkService) {
		this.socialMediaLinkService=socialMediaLinkService;
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<SocialMediaLink>> getByCandidateId(int candidateId){
		return this.socialMediaLinkService.getByCandidateId(candidateId);
	}
	
	@PostMapping("/addSocialMedia")
	public Result addSocialMedia(@RequestBody SocialMediaLink socialMediaLink) {
		return this.socialMediaLinkService.addSocialMedaiLink(socialMediaLink);
	}
}
