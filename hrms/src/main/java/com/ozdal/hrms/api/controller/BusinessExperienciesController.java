package com.ozdal.hrms.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozdal.hrms.business.abstracts.BusinessExperienceService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.BusinessExperience;



@RestController
@RequestMapping("/api/businessExperiencies")
public class BusinessExperienciesController {
	private BusinessExperienceService businessExperienceService;
	
	@Autowired
	public BusinessExperienciesController(BusinessExperienceService businessExperienceService) {
		this.businessExperienceService=businessExperienceService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<BusinessExperience>> getall(){
		return this.businessExperienceService.getAll();
	}
	
	
	@PostMapping("/addBusinessExperience")
	public Result addExperience(@RequestBody BusinessExperience businessExperience) {
		return this.businessExperienceService.addExperience(businessExperience);
	}
	
	
	
}
