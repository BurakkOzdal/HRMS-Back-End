package com.ozdal.hrms.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ozdal.hrms.business.abstracts.SchoolService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		this.schoolService=schoolService;
	}
	
	
	
	@GetMapping("/getAll")
	public DataResult<List<School>> getall(){
		return this.schoolService.getAll();
	}
	@PostMapping("/addSchool")
	public Result addSchool(@RequestBody School school) {
		return this.schoolService.addSchool(school);
	}
}
