package com.ozdal.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ozdal.hrms.business.abstracts.ForeignLanguageService;
import com.ozdal.hrms.core.utilities.results.DataResult;
import com.ozdal.hrms.core.utilities.results.Result;
import com.ozdal.hrms.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignLanguagies")
public class ForeignLanguagiesController {
	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguagiesController(ForeignLanguageService foreignLanguageService) {
		this.foreignLanguageService = foreignLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ForeignLanguage>> getAll(){
		return this.foreignLanguageService.getAll();
	}
	
	@PostMapping("/addForeignLanguage")
	public Result addForeignLanguage(@RequestBody ForeignLanguage foreignLanguage) {
		return this.foreignLanguageService.addForeignLanguage(foreignLanguage);
	}
	
	
}
