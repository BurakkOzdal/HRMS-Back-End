package com.ozdal.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ozdal.hrms.business.abstracts.JobAdvertismentService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisments")
@CrossOrigin
public class JobAdvertisementsController {

	
	private JobAdvertismentService advertismentService;
	@Autowired
	public JobAdvertisementsController(JobAdvertismentService advertismentService) {
		this.advertismentService=advertismentService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.advertismentService.getAll();
	}
	
	
	@PostMapping("/addJobAdvertisement")
	public Result addJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.advertismentService.addJobAvertisement(jobAdvertisement);
		
	}
	
	@GetMapping("/getByStatusTrue")
	public DataResult<List<JobAdvertisement>> getByStatusTrue(){
		return this.advertismentService.getByStatusTrue();
	}
	
	@GetMapping("/getByEmployer")
	public DataResult<List<JobAdvertisement>> getByEmployer(@RequestParam int employerId){
		return this.advertismentService.getByEmployer(employerId);
	}
}
