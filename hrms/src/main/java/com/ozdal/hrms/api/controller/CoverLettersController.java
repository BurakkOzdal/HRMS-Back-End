package com.ozdal.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozdal.hrms.business.abstracts.CoverLetterService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverLetter")
public class CoverLettersController {

	private CoverLetterService coverLetterService;
	
	
	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		this.coverLetterService=coverLetterService;
	}
	
	@GetMapping("/getByCandidateCoverLetter")
	public DataResult<CoverLetter> getByCandidateId(int candidateId){
		return this.coverLetterService.getByCandidateId(candidateId);
	}
	
	@PostMapping("/addCoverLetter")
	public Result addCoverLetter(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.addCoverLetter(coverLetter);
	}
	
}
